package com.manager.ips.Dto;

import com.manager.ips.Model.Ip;
import com.manager.ips.Model.Port;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IpDto {


    private Integer id;
    private String ipValue;
    private List<Port> portsList;

    public IpDto(Ip ip){
        this.id = ip.getId();
        this.ipValue = ip.getIpValue();
    }
}
