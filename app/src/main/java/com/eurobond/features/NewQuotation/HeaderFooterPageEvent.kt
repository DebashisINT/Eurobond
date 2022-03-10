package com.eurobond.features.NewQuotation

import com.itextpdf.text.Document
import com.itextpdf.text.Element
import com.itextpdf.text.pdf.PdfPageEventHelper
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.ColumnText
import com.itextpdf.text.Phrase

class HeaderFooterPageEvent : PdfPageEventHelper() {
    override fun onStartPage(writer: PdfWriter, document: Document) {
        ColumnText.showTextAligned(writer.directContent, Element.ALIGN_CENTER, Phrase("Top Left"), 30f, 800f, 0f)
        ColumnText.showTextAligned(writer.directContent, Element.ALIGN_CENTER, Phrase("Top Right"), 550f, 800f, 0f)
    }

    override fun onEndPage(writer: PdfWriter, document: Document) {
        ColumnText.showTextAligned(writer.directContent, Element.ALIGN_CENTER, Phrase("http://www.xxxx-your_example.com/"), 110f, 30f, 0f)
        ColumnText.showTextAligned(writer.directContent, Element.ALIGN_CENTER, Phrase("page " + document.pageNumber), 550f, 30f, 0f)
    }
}