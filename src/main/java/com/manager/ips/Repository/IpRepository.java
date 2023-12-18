package com.manager.ips.Repository;

import com.manager.ips.Model.Ip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IpRepository extends JpaRepository<Ip,Integer>{

    @Query("select i from Ip i where i.ipValue = :ipValue")
    Ip findByIpValue(@Param("ipValue") String ipValue);
}
