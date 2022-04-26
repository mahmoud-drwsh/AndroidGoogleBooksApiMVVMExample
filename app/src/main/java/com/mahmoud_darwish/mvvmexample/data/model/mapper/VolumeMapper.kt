package com.mahmoud_darwish.mvvmexample.data.model.mapper

import com.mahmoud_darwish.mvvmexample.data.model.VolumeSearchResponseDto
import com.mahmoud_darwish.mvvmexample.domain.model.Volume

fun VolumeSearchResponseDto.VolumeDto.toVolume(): Volume = Volume(
    title = volumeInfo.title,
    price = saleInfo.listPrice.amount
)




