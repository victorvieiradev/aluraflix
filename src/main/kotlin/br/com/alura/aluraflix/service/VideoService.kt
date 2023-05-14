package br.com.alura.aluraflix.service

import br.com.alura.aluraflix.dto.AtualizaVideoForm
import br.com.alura.aluraflix.dto.VideoForm
import br.com.alura.aluraflix.dto.VideoView
import br.com.alura.aluraflix.exceptions.NotFoundException
import br.com.alura.aluraflix.mapper.VideoFormToVideo
import br.com.alura.aluraflix.mapper.VideoToVideoView
import br.com.alura.aluraflix.model.Video
import br.com.alura.aluraflix.repository.CategoriaRepository
import br.com.alura.aluraflix.repository.VideoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class VideoService(
    private val videoToVideoView: VideoToVideoView,
    private val videoFormToVideo: VideoFormToVideo,
    private val videoRepository: VideoRepository,
    private val categoriaRepository: CategoriaRepository
) {
    fun listar(): MutableList<VideoView> {
        return videoRepository.findAll().stream().map {
            videoToVideoView.map(it)
        }.collect(Collectors.toList())
    }

    fun cadastrar(videoForm: VideoForm): VideoView {
        val video = videoFormToVideo.map(videoForm)
        val videoSalvo = videoRepository.save(video)
        return videoToVideoView.map(videoSalvo)
    }

    fun buscarPorId(id: Long): VideoView {
        val video = videoRepository.findById(id).orElseThrow {
            NotFoundException(mensagem = "O vídeo $id não foi encontrado.")
        }
        return videoToVideoView.map(video)
    }

    fun excluir(id: Long) {
        val video = buscarPorId(id)
        videoRepository.deleteById(video.id!!)
    }

    fun atualiza(atualizaVideoForm: AtualizaVideoForm): VideoView {
        val video = buscarPorId(atualizaVideoForm.id)
        return videoToVideoView.map(
            videoRepository.save(
                Video(
                    id = atualizaVideoForm.id,
                    titulo = atualizaVideoForm.titulo ?: video.titulo,
                    descricao = atualizaVideoForm.descricao ?: video.descricao,
                    url = atualizaVideoForm.url ?: video.url,
                    categoria = categoriaRepository.findById(atualizaVideoForm.idCategoria).orElseThrow {
                        NotFoundException("Categoria não encontrada.")
                    }

                )
            )
        )
    }
}