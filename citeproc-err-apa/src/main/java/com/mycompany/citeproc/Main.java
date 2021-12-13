package com.mycompany.citeproc;

import de.undercouch.citeproc.CSL;
import de.undercouch.citeproc.ListItemDataProvider;
import de.undercouch.citeproc.csl.CSLItemDataBuilder;
import de.undercouch.citeproc.csl.CSLNameBuilder;
import de.undercouch.citeproc.csl.CSLType;
import de.undercouch.citeproc.csl.internal.format.Format;
import de.undercouch.citeproc.helper.json.JsonBuilder;
import de.undercouch.citeproc.helper.json.StringJsonBuilderFactory;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        var item = new CSLItemDataBuilder().id("60f065df404ba66b0d890be5")
                .type(CSLType.BOOK)
                .language("eng")
                .author(    new CSLNameBuilder()
                            .literal("Robert Southey")
                            .build())
                .editorialDirector(
                           new CSLNameBuilder()
                            .literal("Jonathan González")
                            .build(),
                           new CSLNameBuilder()
                            .literal("Cristina Flores")
                            .build()
                )
                .issued(2021)
                .publisher("Routledge")
                .title("Letters Written During a Short Residence in Spain and Portugal by Robert Southey")
                .containerTitle("Letters Written During a Short Residence in Spain and Portugal by Robert Southey")
                .build();
        
        var itemDataProvider = new ListItemDataProvider(List.of(item));
        
        var csl = new CSL(itemDataProvider, "apa", "es-ES");
        
        csl.registerCitationItems(itemDataProvider.getIds());
        csl.setOutputFormat("text");
        
        
        
        
        System.out.println(csl.makeBibliography().makeString());
        

    }
}
