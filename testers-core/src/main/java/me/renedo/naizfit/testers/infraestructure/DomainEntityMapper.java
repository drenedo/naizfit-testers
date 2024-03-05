package me.renedo.naizfit.testers.infraestructure;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;

import me.renedo.naizfit.testers.domain.BirthDate;
import me.renedo.naizfit.testers.domain.Brand;
import me.renedo.naizfit.testers.domain.Dimension;
import me.renedo.naizfit.testers.domain.Email;
import me.renedo.naizfit.testers.domain.Measure;
import me.renedo.naizfit.testers.domain.Name;
import me.renedo.naizfit.testers.domain.Product;
import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.SKU;
import me.renedo.naizfit.testers.domain.Sex;
import me.renedo.naizfit.testers.domain.Size;
import me.renedo.naizfit.testers.domain.Sizes;
import me.renedo.naizfit.testers.domain.Test;
import me.renedo.naizfit.testers.domain.TestAggregate;
import me.renedo.naizfit.testers.domain.Tester;
import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TestsDone;
import me.renedo.naizfit.testers.infraestructure.jpa.BrandEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.MeasureEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.ProductEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.TestEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntity;

public class DomainEntityMapper {

    private final static String SEPARATOR = ",";

    public static MeasureEntity toMeasureEntity(Measure measure, TesterEntity tester) {
        return new MeasureEntity(measure.getId(), measure.getCreationDate(), tester,
                BigDecimal.valueOf(measure.getWeight().getValue()), BigDecimal.valueOf(measure.getHeight().getValue()));
    }

    public static Product toProduct(ProductEntity productEntity) {
        return new Product(productEntity.getId(), new SKU(productEntity.getSku()),
                new Sizes(Arrays.stream(productEntity.getSizes().split(SEPARATOR)).map(Size::new).collect(Collectors.toList())),
                Arrays.stream(productEntity.getPictures().split(SEPARATOR)).map(DomainEntityMapper::toURL).collect(Collectors.toSet()),
                new Brand(productEntity.getBrand().getId(), new Name(productEntity.getBrand().getName()), toURL(productEntity.getBrand().getLogo())),
                productEntity.getColor());
    }

    public static TestAggregate toTestAggregate(TestEntity testerEntity) {
        return new TestAggregate(new Test(testerEntity.getId(), toTester(testerEntity.getTester()), toProduct(testerEntity.getProduct()),
                        new Size(testerEntity.getSize())));
    }

    public static TestEntity toTestEntity(Test test, ProductEntity productEntity, TesterEntity testerEntity) {
        return new TestEntity(test.getId(), testerEntity, productEntity, test.getSize().getValue());
    }

    public static TesterAggregate toTesterAggregate(TesterEntity testerEntity) {
        return new TesterAggregate(toTester(testerEntity));
    }

    public static Tester toTester(TesterEntity testerEntity) {
        return new Tester(testerEntity.getId(), new Name(testerEntity.getName()), new Email(testerEntity.getEmail()), testerEntity.getPassword(),
                new BirthDate(testerEntity.getBirthDate()),
                testerEntity.getSex().equals("M") ? Sex.MALE : Sex.FEMALE, new TestsDone(testerEntity.getTestsDone()),
                testerEntity.getMeasures().stream().map(DomainEntityMapper::toMeasure).toList());
    }

    public static Measure toMeasure(MeasureEntity measureEntity) {
        return new Measure(measureEntity.getId(), measureEntity.getCreationDate(), new Dimension(measureEntity.getWeight().doubleValue()),
                new Dimension(measureEntity.getHeight().doubleValue()));
    }

    public static BrandEntity toBrandEntity(Brand brand) {
        return new BrandEntity(brand.getId(), brand.getName().getValue(), brand.getLogo().toString());
    }

    public static ProductEntity toProductEntity(Product product, BrandEntity brandEntity) {
        return new ProductEntity(product.getId(), product.getSku().getValue(),
                product.getSizes().getValue().stream().map(Size::getValue).collect(Collectors.joining(SEPARATOR)),
                product.getPictures().stream().map(URL::toString).collect(Collectors.joining(SEPARATOR)), brandEntity, product.getColor());
    }

    public static ProductAggregate toProductAggregate(ProductEntity productEntity) {
        return new ProductAggregate(toProduct(productEntity));
    }

    public static TesterEntity toTesterEntity(Tester tester) {
        return new TesterEntity(tester.getId(), tester.getName().getValue(), tester.getEmail().getValue(), tester.getPassword(),
                tester.getBirthDate().getValue(), tester.getSex().equals(Sex.MALE) ? "M" : "F", tester.getTestsDone().getValue(), null);
    }

    private static URL toURL(String s) {
        try {
            return new URL(s);
        } catch (MalformedURLException e) {
            //TODO think about this
            throw new RuntimeException(e);
        }
    }
}
