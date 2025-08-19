package eu.project.application.export.service

import eu.project.application.export.model.Word

interface CsvService {

    fun prepareFileToExportWords(wordsToExport: List<Word>): ByteArray
}