package io.github.wulkanowymanager.data

import io.github.wulkanowymanager.data.repositories.BuildRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
    single { BuildRepository(get()) }
}
