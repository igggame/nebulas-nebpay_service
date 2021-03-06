package io.nebulas.dapp.pay.service.thirdparty.neb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Desc:
 * User: nathan
 * Date: 2018-02-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDynastyRequest implements Serializable {
    private Long height;
}
