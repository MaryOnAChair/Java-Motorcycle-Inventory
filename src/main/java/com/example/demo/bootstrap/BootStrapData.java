package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (productRepository.count() == 0 && inhousePartRepository.count() == 0 && outsourcedPartRepository.count() == 0) {

            Product hondaCBR500 = new Product(500, "Honda CBR 500", 5500.0, 25);
            productRepository.save(hondaCBR500);

            Product yamahaR3 = new Product(300, "Yamaha R3", 5000.0, 25);
            productRepository.save(yamahaR3);

            Product hondaCBR600rr = new Product(600, "Honda CBR 600rr", 8000.0, 15);
            productRepository.save(hondaCBR600rr);

            Product YamahaR7 = new Product(700, "Yamaha R7", 6000.0, 30);
            productRepository.save(YamahaR7);

            Product ducatiPanigale = new Product(1000, "Ducati Panigale V4", 25000.0, 20);
            productRepository.save(ducatiPanigale);



            OutsourcedPart exhaustLeoVince = new OutsourcedPart();
            exhaustLeoVince.setId(10);
            exhaustLeoVince.setName("Exhaust Leo Vince");
            exhaustLeoVince.setPrice(300.0);
            exhaustLeoVince.setInv(50);
            exhaustLeoVince.setMinInv(2);
            exhaustLeoVince.setMaxInv(100);
            exhaustLeoVince.setCompanyName("Leo Vince");
            outsourcedPartRepository.save(exhaustLeoVince);
            System.out.println(exhaustLeoVince.getName());


            OutsourcedPart mirrorsStealth = new OutsourcedPart();
            mirrorsStealth.setId(120);
            mirrorsStealth.setName("Stealth Mirrors");
            mirrorsStealth.setPrice(100.0);
            mirrorsStealth.setInv(50);
            mirrorsStealth.setMinInv(2);
            mirrorsStealth.setMaxInv(100);
            mirrorsStealth.setCompanyName("Revzilla");
            outsourcedPartRepository.save(mirrorsStealth);
            System.out.println(mirrorsStealth.getName());


            InhousePart OEMHondaFairings = new InhousePart();
            OEMHondaFairings.setId(130);
            OEMHondaFairings.setName("OEM Honda Fairings");
            OEMHondaFairings.setPrice(1200.0);
            OEMHondaFairings.setInv(50);
            OEMHondaFairings.setMinInv(3);
            OEMHondaFairings.setMaxInv(100);
            inhousePartRepository.save(OEMHondaFairings);
            System.out.println(OEMHondaFairings.getName());


            InhousePart OEMYamahaFairings = new InhousePart();
            OEMYamahaFairings.setId(140);
            OEMYamahaFairings.setName("OEM Yamaha Fairings");
            OEMYamahaFairings.setPrice(1100.0);
            OEMYamahaFairings.setInv(50);
            OEMYamahaFairings.setMinInv(2);
            OEMYamahaFairings.setMaxInv(100);
            inhousePartRepository.save(OEMYamahaFairings);
            System.out.println(OEMYamahaFairings.getName());


            InhousePart DucatiFairings = new InhousePart();
            DucatiFairings.setId(150);
            DucatiFairings.setName("OEM Ducati Fairings");
            DucatiFairings.setPrice(1600.0);
            DucatiFairings.setInv(50);
            DucatiFairings.setMinInv(2);
            DucatiFairings.setMaxInv(100);
            inhousePartRepository.save(DucatiFairings);
            System.out.println(DucatiFairings.getName());

        }



        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
