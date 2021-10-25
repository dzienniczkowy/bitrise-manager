package io.github.wulkanowy.manager.app.ui.modules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.wulkanowy.manager.app.ui.modules.develop.DevelopScreen
import io.github.wulkanowy.manager.app.ui.modules.stable.StableScreen
import io.github.wulkanowy.manager.app.ui.modules.unstable.UnstableScreen
import io.github.wulkanowy.manager.app.ui.theme.WulkanowyManagerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WulkanowyManagerApp()
        }
    }
}

@Composable
fun WulkanowyManagerApp() {
    WulkanowyManagerTheme {
        val navController = rememberNavController()

        Scaffold(bottomBar = { BottomNavigation(navController) }) {
            NavHost(navController, it)
        }
    }
}

@Composable
fun NavHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Develop.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(Screen.Stable.route) { StableScreen(navController) }
        composable(Screen.Develop.route) { DevelopScreen(navController, hiltViewModel()) }
        composable(Screen.Unstable.route) { UnstableScreen(navController) }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        Screen.Stable,
        Screen.Develop,
        Screen.Unstable,
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach {
            BottomNavigationItem(
                navController = navController,
                currentDestination = currentDestination,
                screen = it
            )
        }
    }
}

@Composable
fun RowScope.BottomNavigationItem(
    navController: NavController,
    currentDestination: NavDestination?,
    screen: Screen,
) {
    BottomNavigationItem(
        icon = { Icon(screen.icon, contentDescription = null) },
        label = { Text(screen.resource) },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}

sealed class Screen(val route: String, val resource: String, val icon: ImageVector) {
    object Stable : Screen("stable", "Stable", Icons.Filled.Home)
    object Develop : Screen("develop", "Develop", Icons.Filled.Delete)
    object Unstable : Screen("unstable", "Unstable", Icons.Filled.Star)
}
