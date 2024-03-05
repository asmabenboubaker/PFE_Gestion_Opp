package biz.picosoft.demo.controller;

import biz.picosoft.demo.service.dto.ContentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/extractor")
@RequiredArgsConstructor
@Validated
public class ContentExtractorBoundary {

    private final ContentExtractorControl contentExtractorControl;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContentResponseDto> classify(@Valid @NotNull @RequestParam("file") final MultipartFile pdfFile) {
        return ResponseEntity.ok().body(ContentResponseDto.builder().content(this.contentExtractorControl.extractContent(pdfFile)).build());
    }


}