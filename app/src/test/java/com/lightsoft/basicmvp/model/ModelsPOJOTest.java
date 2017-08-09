package com.lightsoft.basicmvp.model;

import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import org.junit.Test;

public class ModelsPOJOTest {
    private static final String POJO_PACKAGE = "com.lightsoft.basicmvp.model";

    @Test
    public void testModelsPOJOStructures() throws Exception {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
        validator.validate(POJO_PACKAGE, new FilterPackageInfo());
    }
}