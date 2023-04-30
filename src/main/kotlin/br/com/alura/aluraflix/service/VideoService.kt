package br.com.alura.aluraflix.service

import br.com.alura.aluraflix.dto.VideoFormDto
import br.com.alura.aluraflix.dto.VideoViewDto
import br.com.alura.aluraflix.exceptions.NotFoundException
import br.com.alura.aluraflix.mapper.VideoFormDtoMapper
import br.com.alura.aluraflix.mapper.VideoViewMapper
import br.com.alura.aluraflix.repository.VideoRepository
import org.springframework.stereotype.Service

@Service
class VideoService(
    private val videoViewMapper: VideoViewMapper,
    private val videoFormDtoMapper: VideoFormDtoMapper,
    private val videoRepository: VideoRepository
) {
    fun cadastrar(videoFormDto: VideoFormDto): VideoViewDto {
        val video = videoFormDtoMapper.map(videoFormDto)
        val videoSalvo = videoRepository.save(video)
        return videoViewMapper.map(videoSalvo)
    }

    fun buscarPorId(id: Long): VideoViewDto {
        val video = videoRepository.findById(id).orElseThrow{
            NotFoundException(mensagem = "O vídeo $id não foi encontrado.")
        }
        return videoViewMapper.map(video)
    }
    fun excluir(id: Long){
        val video = buscarPorId(id)
        videoRepository.deleteById(video.id!!)
    }
}