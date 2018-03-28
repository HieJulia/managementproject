package com.hien.project.ws.endpoint;


import com.hien.project.model.data.InvoicedProducts;
import com.hien.project.service.AccountReceivableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountReceivableServiceEndpoint {

    private static final String TARGET_NAMESPACE = "http://invprod.packt.erp.modules.org/getInvoicedProduct";

    //
    @Autowired
    private AccountReceivableService accountReceivableService;

    @PayloadRoot(localPart = "InvoiceProductRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload InvoiceProductResponse getAccountDetails(
            @RequestPayload InvoiceProductRequest request) {
        InvoiceProductResponse response = new InvoiceProductResponse();
        InvoicedProducts account = accountReceivableService
                .getInvProduct(request.getInvoiceId());
        response.setInvoicedProduct(account);
        return response;
    }

    public void setAccountReceivableService(
            AccountReceivableService accountReceivableService) {
        this.accountReceivableService = accountReceivableService;
    }

}
