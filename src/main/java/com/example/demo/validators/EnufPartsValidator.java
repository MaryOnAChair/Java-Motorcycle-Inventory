package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        PartService partService = myContext.getBean(PartServiceImpl.class);
        Boolean valid = false;
        if (product.getId() != 0) {
            Product myProduct = repo.findById((int) product.getId());
            for (Part p : myProduct.getParts()) {

                //Part Inventory cannot be below part Min inventory
                if(p.getMinInv() > (p.getInv() - (product.getInv()-myProduct.getInv()))){
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is can't be below minimum, Please Fix :)").addConstraintViolation();
                    valid = false;
                }

                //Part Inventory cannot be below new amount
                if (p.getInv()<(p.getInv() - (product.getInv()-myProduct.getInv()))) {
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory error, Please Fix :)").addConstraintViolation();
                    valid = false;
                }
                //Part inventory Max cannot be below new amount
                if (p.getMaxInv()<(p.getInv() - (product.getInv()-myProduct.getInv()))) {
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory error, Please Fix :)").addConstraintViolation();
                    valid = false;
                }
                else if(p.getInv()> (p.getInv() - (product.getInv()-myProduct.getInv()))){
                    int inv = p.getInv();
                    p.setInv(inv - (product.getInv() - myProduct.getInv()));
                    partService.save(p);
                    valid = true;
            }

        }}


        return valid;
    }}

