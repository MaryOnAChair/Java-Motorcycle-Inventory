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

        if(productRepository.count()==0 && inhousePartRepository.count()==0 && outsourcedPartRepository.count()==0) {

            Product hondaCBR500 = new Product(500, "Honda CBR 500", 5500.0, 8);
            productRepository.save(hondaCBR500);
            // Add Min and Max Values

            Product yamahaR3 = new Product(300, "Yamaha R3", 5000.0, 10);
            productRepository.save(yamahaR3);
            // Add Min and Max Values

            Product hondaCBR600rr = new Product(600, "Honda CBR 600rr", 8000.0, 6);
            productRepository.save(hondaCBR600rr);
            // Add Min and Max Values

            Product YamahaR7 = new Product(700, "Yamaha R7", 6000.0, 5);
            productRepository.save(YamahaR7);
            // Add Min and Max Values

            Product ducatiPanigale = new Product(1000, "Ducati Panigale V4", 25000.0, 4);
            productRepository.save(ducatiPanigale);
            // Add Min and Max Values


            OutsourcedPart exhaustLeoVince = new OutsourcedPart();
            exhaustLeoVince.setId(10);
            exhaustLeoVince.setName("Exhaust Leo Vince");
            exhaustLeoVince.setPrice(300.0);
            exhaustLeoVince.setInv(10);
            exhaustLeoVince.setMinInv(2);
            exhaustLeoVince.setMaxInv(20);
            outsourcedPartRepository.save(exhaustLeoVince);

            OutsourcedPart mirrorsStealth = new OutsourcedPart();
            mirrorsStealth.setId(20);
            mirrorsStealth.setName("Stealth Mirrors");
            mirrorsStealth.setPrice(100.0);
            mirrorsStealth.setInv(5);
            mirrorsStealth.setMinInv(2);
            mirrorsStealth.setMaxInv(15);
            outsourcedPartRepository.save(mirrorsStealth);


            InhousePart OEMHondaFairings = new InhousePart();
            OEMHondaFairings.setId(30);
            OEMHondaFairings.setName("OEM Honda Fairings");
            OEMHondaFairings.setPrice(1200.0);
            OEMHondaFairings.setInv(5);
            OEMHondaFairings.setMinInv(3);
            OEMHondaFairings.setMaxInv(20);
            inhousePartRepository.save(OEMHondaFairings);

            InhousePart OEMYamahaFairings = new InhousePart();
            OEMYamahaFairings.setId(40);
            OEMYamahaFairings.setName("OEM Yamaha Fairings");
            OEMYamahaFairings.setPrice(1100.0);
            OEMYamahaFairings.setInv(6);
            OEMYamahaFairings.setMinInv(2);
            OEMYamahaFairings.setMaxInv(25);
            inhousePartRepository.save(OEMYamahaFairings);


            InhousePart DucatiFairings = new InhousePart();
            DucatiFairings.setId(50);
            DucatiFairings.setName("OEM Ducati Fairings");
            DucatiFairings.setPrice(1600.0);
            DucatiFairings.setInv(5);
            DucatiFairings.setMinInv(2);
            DucatiFairings.setMaxInv(10);
            inhousePartRepository.save(DucatiFairings);

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
