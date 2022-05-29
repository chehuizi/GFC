package com.bmf.base.strategy.asymmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.role.cs.CustomerRole;
import com.bmf.base.strategy.role.cs.SupplierRole;
import lombok.Data;

/**
 * 非对称关系：客户/供应商关系
 */
@Data
public class CustomerSupplierRelationship extends AsymmetricRelationship {

    /**
     * 上游
     */
    private CustomerRole customer;
    /**
     * 下游
     */
    private SupplierRole supplier;

    public CustomerSupplierRelationship() {
        super.setRelationship(RelationshipEnum.CS.getType());
        customer = new CustomerRole();
        supplier = new SupplierRole();
    }

    @Override
    public String toString() {
        return "{" +
                "\"relationship\": \"" + super.getRelationship() + "\"" +
                ", \"customer\": \"" + customer.getDomain().getDomainName() + "\"" +
                ", \"supplier\": \"" + supplier.getDomain().getDomainName() + "\"" +
                "}";
    }
}
