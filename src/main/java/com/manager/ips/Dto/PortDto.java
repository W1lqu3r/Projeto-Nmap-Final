package com.manager.ips.Dto;

import com.manager.ips.Model.Ip;
import com.manager.ips.Model.Port;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PortDto {

    private Integer id;

    private String portValue;

    private boolean open; //true open, false in use

    private Ip ip;

    public PortDto(Port port){
        this.id = port.getId();
        this.portValue = port.getPortValue();
        this.open = port.isOpen();
        this.ip = port.getIp();
    }
}
