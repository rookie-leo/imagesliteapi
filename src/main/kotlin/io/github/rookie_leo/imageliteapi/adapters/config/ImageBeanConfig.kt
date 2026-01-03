package io.github.rookie_leo.imageliteapi.adapters.config

import io.github.rookie_leo.imageliteapi.adapters.out.database.ImageDatabase
import io.github.rookie_leo.imageliteapi.core.usecases.impl.ImageUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ImageBeanConfig {

    @Bean
    fun imageUseCaseImpl(database: ImageDatabase): ImageUseCaseImpl =
        ImageUseCaseImpl(database)

}