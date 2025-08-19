package eu.project.application.export.controller

import eu.project.application.export.model.ExportDownloadRequest
import eu.project.application.export.service.CsvService
import jakarta.validation.Valid
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExportController(val csvService: CsvService) {

    @PostMapping("/siaapi/exports/download", produces = ["text/csv"])
    fun exportDownload(@Valid @RequestBody exportDownloadRequest: ExportDownloadRequest): ResponseEntity<ByteArray> {

        val csvBytes = csvService.prepareFileToExportWords(exportDownloadRequest.wordsToExport)

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"words.csv\"")
            .contentType(MediaType.parseMediaType("text/csv"))
            .body(csvBytes)
    }
}