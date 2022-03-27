/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.services;

import io.arpaul.myshop.payload.schemas.Address;
import io.arpaul.myshop.payload.shared.AddressDto;

/**
 *
 * @author ARPaul
 */
public class AddressService {

    public static AddressDto mapToDto(Address address) {
        if(address != null) {
            return new AddressDto(
                    address.getAddress1(),
                    address.getAddress2(),
                    address.getCity(),
                    address.getPostcode(),
                    address.getCountry()
            );
        }
        return null;
    }
}
