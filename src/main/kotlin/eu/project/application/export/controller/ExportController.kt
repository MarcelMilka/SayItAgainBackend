package eu.project.application.export.controller

import eu.project.application.export.model.ExportDownloadRequest
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExportController {

    @PostMapping("/siaapi/exports/download")
    fun exportDownload(@Valid @RequestBody exportDownloadRequest: ExportDownloadRequest): String {

        // TODO: replace with real logic
        return exportDownloadRequest.wordsToExport.toString()
    }
}