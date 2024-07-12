

//import com.custom.eaii.training.DTO.Create.CreateIntelInfoResponse;
//import com.custom.eaii.training.DTO.Create.RegisterIntelInfoCommand;
//import com.custom.eaii.training.DTO.search.SearchIntelInfoResponse;
//import com.custom.eaii.training.api.Response;
//import com.custom.eaii.training.ports.input.service.IntelInfoApplicationService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController()
//@RequestMapping("intelInfos")
//public class IntelInfoController {
//
//    private final IntelInfoApplicationService intelInfoApplicationService;
//
//    public IntelInfoController(IntelInfoApplicationService intelInfoApplicationService) {
//        this.intelInfoApplicationService = intelInfoApplicationService;
//    }
//
//
//    @PostMapping()
//    public Response<CreateIntelInfoResponse> CreateIntelInfo(@RequestBody RegisterIntelInfoCommand registerIntelInfoCommand) {
//        CreateIntelInfoResponse response = intelInfoApplicationService.CreateIntelInfo(registerIntelInfoCommand);
//        return new Response<>(response);
//    }
//    @GetMapping()
//    public Response<SearchIntelInfoResponse> searchIntelInfo() {
//        SearchIntelInfoResponse searchInformantResponse = intelInfoApplicationService.searchIntelInfos();
//        return new Response<>(searchInformantResponse);
//    }
//}
//
package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateIntelInfoResponse;
import com.custom.eaii.training.DTO.Create.RegisterIntelInfoCommand;
import com.custom.eaii.training.DTO.search.SearchIntelInfoResponse;
import com.custom.eaii.training.api.Response;
import com.custom.eaii.training.ports.input.service.IntelInfoApplicationService;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("informant")

public class IntelInfoController {
    private final IntelInfoApplicationService intelInfoApplicationService;

    public IntelInfoController(IntelInfoApplicationService intelInfoApplicationService) {
        this.intelInfoApplicationService = intelInfoApplicationService;
    }
    @GetMapping()
    public Response<SearchIntelInfoResponse> searchInformants() {
        SearchIntelInfoResponse searchInformantResponse = intelInfoApplicationService.searchIntelInfos();
        return new Response<>(searchInformantResponse);
    }


    @GetMapping("/{id}")
    public Response<SearchIntelInfoResponse> searchIntelInfo(@PathVariable UUID id) {
        SearchIntelInfoResponse searchIntelInfoResponse = intelInfoApplicationService.searchIntelInfos();
        return new Response<>(searchIntelInfoResponse);
    }



//    @GetMapping("/informants")
//    public Response<SearchIntelInfoResponse> getInformantsByStatus(@RequestParam("status") String status) {
//        SearchIntelInfoResponse searchInformantResponse = intelInfoApplicationService.getInformantsByStatus(status);
//        return new Response<>(searchInformantResponse);
//    }

   /* @GetMapping()
    public Response<SearchIntelInfoResponse> searchByStatus() {
        SearchIntelInfoResponse searchIntelInfoResponse = intelInfoApplicationService.searchByStatus();
        return new Response<>(searchIntelInfoResponse);
    }*/

    @PostMapping
    public Response<CreateIntelInfoResponse> CreateIntelInfo(@RequestBody RegisterIntelInfoCommand registerIntelInfoCommand) {
        CreateIntelInfoResponse response = intelInfoApplicationService.CreateIntelInfo(registerIntelInfoCommand);
        return new Response<>(response);
    }

}