package com.nsi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {

    String serviceId;
    String serviceName;
    String address;
    String legalName;
    String phoneNumber;
    String logoUrl;
    String businessEmail;
    String rcNumber;
    String description;
    ServiceBranch mainBranch;

}
