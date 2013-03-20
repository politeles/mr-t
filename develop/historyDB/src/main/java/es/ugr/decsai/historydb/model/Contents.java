/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.historydb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
@Entity
@Table(name = "CONTENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contents.findAll", query = "SELECT c FROM Contents c")})
public class Contents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMEROWAUTERS")
    private Integer numerowauters;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "LANGUE")
    private String langue;
    @Column(name = "VERACITE")
    private String veracite;
    @Column(name = "DATEMILLESIMEVALEUR1")
    private Integer datemillesimevaleur1;
    @Column(name = "DATEMOISVALEUR1")
    private Integer datemoisvaleur1;
    @Column(name = "DATEJOURVALEUR1")
    private Integer datejourvaleur1;
    @Column(name = "DATECODESVALEUR1")
    private Integer datecodesvaleur1;
    @Column(name = "DATEJUSTIFICATIONSVALEUR1")
    private String datejustificationsvaleur1;
    @Column(name = "MIXDAT1VALEUR1")
    private Integer mixdat1valeur1;
    @Column(name = "MIXDAT2VALEUR1")
    private Integer mixdat2valeur1;
    @Column(name = "MIXDAT3VALEUR1")
    private Integer mixdat3valeur1;
    @Column(name = "MIXDATCCODEVALEUR1")
    private Integer mixdatccodevaleur1;
    @Column(name = "MIXDATJUSVALEUR1")
    private String mixdatjusvaleur1;
    @Column(name = "MIXDAT1VALEUR2")
    private Integer mixdat1valeur2;
    @Column(name = "MIXDAT2VALEUR2")
    private Integer mixdat2valeur2;
    @Column(name = "MIXDAT3VALEUR2")
    private Integer mixdat3valeur2;
    @Column(name = "MIXDATCCODEVALEUR2")
    private Integer mixdatccodevaleur2;
    @Column(name = "MIXDATJUSVALEUR2")
    private String mixdatjusvaleur2;
    @Column(name = "MIXDAT1VALEUR3")
    private Integer mixdat1valeur3;
    @Column(name = "MIXDAT2VALEUR3")
    private Integer mixdat2valeur3;
    @Column(name = "MIXDAT3VALEUR3")
    private Integer mixdat3valeur3;
    @Column(name = "MIXDATCCODEVALEUR3")
    private Integer mixdatccodevaleur3;
    @Column(name = "MIXDATJUSVALEUR3")
    private String mixdatjusvaleur3;
    @Column(name = "MIXDAT1VALEUR4")
    private Integer mixdat1valeur4;
    @Column(name = "MIXDAT2VALEUR4")
    private Integer mixdat2valeur4;
    @Column(name = "MIXDAT3VALEUR4")
    private Integer mixdat3valeur4;
    @Column(name = "MIXDATCCODEVALEUR4")
    private Integer mixdatccodevaleur4;
    @Column(name = "MIXDATJUSVALEUR4")
    private String mixdatjusvaleur4;
    @Column(name = "MIXDAT1VALEUR5")
    private Integer mixdat1valeur5;
    @Column(name = "MIXDAT2VALEUR5")
    private Integer mixdat2valeur5;
    @Column(name = "MIXDAT3VALEUR5")
    private Integer mixdat3valeur5;
    @Column(name = "MIXDATCCODEVALEUR5")
    private Integer mixdatccodevaleur5;
    @Column(name = "MIXDATJUSVALEUR5")
    private String mixdatjusvaleur5;
    @Column(name = "MIXDAT1VALEUR6")
    private Integer mixdat1valeur6;
    @Column(name = "MIXDAT2VALEUR6")
    private Integer mixdat2valeur6;
    @Column(name = "MIXDAT3VALEUR6")
    private Integer mixdat3valeur6;
    @Column(name = "MIXDATCCODEVALEUR6")
    private Integer mixdatccodevaleur6;
    @Column(name = "MIXDATJUSVALEUR6")
    private String mixdatjusvaleur6;
    @Column(name = "MIXDAT1VALEUR7")
    private Integer mixdat1valeur7;
    @Column(name = "MIXDAT2VALEUR7")
    private Integer mixdat2valeur7;
    @Column(name = "MIXDAT3VALEUR7")
    private Integer mixdat3valeur7;
    @Column(name = "MIXDATCCODEVALEUR7")
    private Integer mixdatccodevaleur7;
    @Column(name = "MIXDATJUSVALEUR7")
    private String mixdatjusvaleur7;
    @Column(name = "MIXDAT1VALEUR8")
    private Integer mixdat1valeur8;
    @Column(name = "MIXDAT2VALEUR8")
    private Integer mixdat2valeur8;
    @Column(name = "MIXDAT3VALEUR8")
    private Integer mixdat3valeur8;
    @Column(name = "MIXDATCCODEVALEUR8")
    private Integer mixdatccodevaleur8;
    @Column(name = "MIXDATJUSVALEUR8")
    private String mixdatjusvaleur8;
    @Column(name = "MIXDAT1VALEUR9")
    private Integer mixdat1valeur9;
    @Column(name = "MIXDAT2VALEUR9")
    private Integer mixdat2valeur9;
    @Column(name = "MIXDAT3VALEUR9")
    private Integer mixdat3valeur9;
    @Column(name = "MIXDATCCODEVALEUR9")
    private Integer mixdatccodevaleur9;
    @Column(name = "MIXDATJUSVALEUR9")
    private String mixdatjusvaleur9;
    @Column(name = "MIXDAT1VALEUR10")
    private Integer mixdat1valeur10;
    @Column(name = "MIXDAT2VALEUR10")
    private Integer mixdat2valeur10;
    @Column(name = "MIXDAT3VALEUR10")
    private Integer mixdat3valeur10;
    @Column(name = "MIXDATCCODEVALEUR10")
    private Integer mixdatccodevaleur10;
    @Column(name = "MIXDATJUSVALEUR10")
    private String mixdatjusvaleur10;
    @Column(name = "MIXDAT1VALEUR11")
    private Integer mixdat1valeur11;
    @Column(name = "MIXDAT2VALEUR11")
    private Integer mixdat2valeur11;
    @Column(name = "MIXDAT3VALEUR11")
    private Integer mixdat3valeur11;
    @Column(name = "MIXDATCCODEVALEUR11")
    private Integer mixdatccodevaleur11;
    @Column(name = "MIXDATJUSVALEUR11")
    private String mixdatjusvaleur11;
    @Column(name = "MIXDAT1VALEUR12")
    private Integer mixdat1valeur12;
    @Column(name = "MIXDAT2VALEUR12")
    private Integer mixdat2valeur12;
    @Column(name = "MIXDAT3VALEUR12")
    private Integer mixdat3valeur12;
    @Column(name = "MIXDATCCODEVALEUR12")
    private Integer mixdatccodevaleur12;
    @Column(name = "MIXDATJUSVALEUR12")
    private Integer mixdatjusvaleur12;
    @Column(name = "MIXDAT1VALEUR13")
    private Integer mixdat1valeur13;
    @Column(name = "MIXDAT2VALEUR13")
    private Integer mixdat2valeur13;
    @Column(name = "MIXDAT3VALEUR13")
    private Integer mixdat3valeur13;
    @Column(name = "MIXDATCCODEVALEUR13")
    private Integer mixdatccodevaleur13;
    @Column(name = "MIXDATJUSVALEUR13")
    private Integer mixdatjusvaleur13;
    @Column(name = "MIXDAT1VALEUR14")
    private Integer mixdat1valeur14;
    @Column(name = "MIXDAT2VALEUR14")
    private Integer mixdat2valeur14;
    @Column(name = "MIXDAT3VALEUR14")
    private Integer mixdat3valeur14;
    @Column(name = "MIXDATCCODEVALEUR14")
    private Integer mixdatccodevaleur14;
    @Column(name = "MIXDATJUSVALEUR14")
    private Integer mixdatjusvaleur14;
    @Column(name = "AUTEUR1VALEUR1")
    private String auteur1valeur1;
    @Column(name = "AUTEUR2VALEUR1")
    private String auteur2valeur1;
    @Column(name = "AUTEUR1VALEUR2")
    private Integer auteur1valeur2;
    @Column(name = "AUTEUR2VALEUR2")
    private Integer auteur2valeur2;
    @Column(name = "AUTEUR1VALEUR3")
    private Integer auteur1valeur3;
    @Column(name = "AUTEUR2VALEUR3")
    private Integer auteur2valeur3;
    @Column(name = "AUTEUR1VALEUR4")
    private Integer auteur1valeur4;
    @Column(name = "AUTEUR2VALEUR4")
    private Integer auteur2valeur4;
    @Column(name = "AUTEUR1VALEUR5")
    private Integer auteur1valeur5;
    @Column(name = "AUTEUR2VALEUR5")
    private Integer auteur2valeur5;
    @Column(name = "AUTEUR1VALEUR6")
    private Integer auteur1valeur6;
    @Column(name = "AUTEUR2VALEUR6")
    private Integer auteur2valeur6;
    @Column(name = "AUTEUR1VALEUR7")
    private Integer auteur1valeur7;
    @Column(name = "AUTEUR2VALEUR7")
    private Integer auteur2valeur7;
    @Column(name = "AUTEUR1VALEUR8")
    private Integer auteur1valeur8;
    @Column(name = "AUTEUR2VALEUR8")
    private Integer auteur2valeur8;
    @Column(name = "AUTEUR1VALEUR9")
    private Integer auteur1valeur9;
    @Column(name = "AUTEUR2VALEUR9")
    private Integer auteur2valeur9;
    @Column(name = "AUTEUR1VALEUR10")
    private Integer auteur1valeur10;
    @Column(name = "AUTEUR2VALEUR10")
    private Integer auteur2valeur10;
    @Column(name = "AUTEUR1VALEUR11")
    private Integer auteur1valeur11;
    @Column(name = "AUTEUR2VALEUR11")
    private Integer auteur2valeur11;
    @Column(name = "AUTEUR1VALEUR12")
    private Integer auteur1valeur12;
    @Column(name = "AUTEUR2VALEUR12")
    private Integer auteur2valeur12;
    @Column(name = "DISPOSANT1VALEUR1")
    private String disposant1valeur1;
    @Column(name = "DISPOSANT2VALEUR1")
    private String disposant2valeur1;
    @Column(name = "DISPOSANT1VALEUR2")
    private Integer disposant1valeur2;
    @Column(name = "DISPOSANT2VALEUR2")
    private Integer disposant2valeur2;
    @Column(name = "DISPOSANT1VALEUR3")
    private Integer disposant1valeur3;
    @Column(name = "DISPOSANT2VALEUR3")
    private Integer disposant2valeur3;
    @Column(name = "DISPOSANT1VALEUR4")
    private Integer disposant1valeur4;
    @Column(name = "DISPOSANT2VALEUR4")
    private Integer disposant2valeur4;
    @Column(name = "DISPOSANT1VALEUR5")
    private Integer disposant1valeur5;
    @Column(name = "DISPOSANT2VALEUR5")
    private Integer disposant2valeur5;
    @Column(name = "DISPOSANT1VALEUR6")
    private Integer disposant1valeur6;
    @Column(name = "DISPOSANT2VALEUR6")
    private Integer disposant2valeur6;
    @Column(name = "DISPOSANT1VALEUR7")
    private Integer disposant1valeur7;
    @Column(name = "DISPOSANT2VALEUR7")
    private Integer disposant2valeur7;
    @Column(name = "DISPOSANT1VALEUR8")
    private Integer disposant1valeur8;
    @Column(name = "DISPOSANT2VALEUR8")
    private Integer disposant2valeur8;
    @Column(name = "DISPOSANT1VALEUR9")
    private Integer disposant1valeur9;
    @Column(name = "DISPOSANT2VALEUR9")
    private Integer disposant2valeur9;
    @Column(name = "DISPOSANT1VALEUR10")
    private Integer disposant1valeur10;
    @Column(name = "DISPOSANT2VALEUR10")
    private Integer disposant2valeur10;
    @Column(name = "DISPOSANT1VALEUR11")
    private Integer disposant1valeur11;
    @Column(name = "DISPOSANT2VALEUR11")
    private Integer disposant2valeur11;
    @Column(name = "DISPOSANT1VALEUR12")
    private Integer disposant1valeur12;
    @Column(name = "DISPOSANT2VALEUR12")
    private Integer disposant2valeur12;
    @Column(name = "BENEFICIAIRE1VALEUR1")
    private String beneficiaire1valeur1;
    @Column(name = "BENEFICIAIRE2VALEUR1")
    private String beneficiaire2valeur1;
    @Column(name = "BENEFICIAIRE1VALEUR2")
    private String beneficiaire1valeur2;
    @Column(name = "BENEFICIAIRE2VALEUR2")
    private Integer beneficiaire2valeur2;
    @Column(name = "BENEFICIAIRE1VALEUR3")
    private String beneficiaire1valeur3;
    @Column(name = "BENEFICIAIRE2VALEUR3")
    private Integer beneficiaire2valeur3;
    @Column(name = "BENEFICIAIRE1VALEUR4")
    private String beneficiaire1valeur4;
    @Column(name = "BENEFICIAIRE2VALEUR4")
    private Integer beneficiaire2valeur4;
    @Column(name = "BENEFICIAIRE1VALEUR5")
    private Integer beneficiaire1valeur5;
    @Column(name = "BENEFICIAIRE2VALEUR5")
    private Integer beneficiaire2valeur5;
    @Column(name = "BENEFICIAIRE1VALEUR6")
    private Integer beneficiaire1valeur6;
    @Column(name = "BENEFICIAIRE2VALEUR6")
    private Integer beneficiaire2valeur6;
    @Column(name = "BENEFICIAIRE1VALEUR7")
    private Integer beneficiaire1valeur7;
    @Column(name = "BENEFICIAIRE2VALEUR7")
    private Integer beneficiaire2valeur7;
    @Column(name = "BENEFICIAIRE1VALEUR8")
    private Integer beneficiaire1valeur8;
    @Column(name = "BENEFICIAIRE2VALEUR8")
    private Integer beneficiaire2valeur8;
    @Column(name = "BENEFICIAIRE1VALEUR9")
    private Integer beneficiaire1valeur9;
    @Column(name = "BENEFICIAIRE2VALEUR9")
    private Integer beneficiaire2valeur9;
    @Column(name = "LIEUNONIDENTIFIE")
    private String lieunonidentifie;
    @Column(name = "LIEUIDENTIFIE")
    private String lieuidentifie;
    @Column(name = "ANALYSE")
    private String analyse;
    @Column(name = "EDITIONSAW")
    private String editionsaw;
    @Column(name = "EDITIONSNW1VALEUR1")
    private String editionsnw1valeur1;
    @Column(name = "EDITIONSNW2VALEUR1")
    private String editionsnw2valeur1;
    @Column(name = "EDITIONSNW3VALEUR1")
    private Integer editionsnw3valeur1;
    @Column(name = "EDITIONSNW4VALEUR1")
    private String editionsnw4valeur1;
    @Column(name = "EDITIONSNW5VALEUR1")
    private String editionsnw5valeur1;
    @Column(name = "EDITIONSNWLINKVALEUR1")
    private String editionsnwlinkvaleur1;
    @Column(name = "EDITIONSNW1VALEUR2")
    private String editionsnw1valeur2;
    @Column(name = "EDITIONSNW2VALEUR2")
    private String editionsnw2valeur2;
    @Column(name = "EDITIONSNW3VALEUR2")
    private Integer editionsnw3valeur2;
    @Column(name = "EDITIONSNW4VALEUR2")
    private String editionsnw4valeur2;
    @Column(name = "EDITIONSNW5VALEUR2")
    private String editionsnw5valeur2;
    @Column(name = "EDITIONSNWLINKVALEUR2")
    private Integer editionsnwlinkvaleur2;
    @Column(name = "EDITIONSNW1VALEUR3")
    private String editionsnw1valeur3;
    @Column(name = "EDITIONSNW2VALEUR3")
    private String editionsnw2valeur3;
    @Column(name = "EDITIONSNW3VALEUR3")
    private Integer editionsnw3valeur3;
    @Column(name = "EDITIONSNW4VALEUR3")
    private String editionsnw4valeur3;
    @Column(name = "EDITIONSNW5VALEUR3")
    private String editionsnw5valeur3;
    @Column(name = "EDITIONSNWLINKVALEUR3")
    private Integer editionsnwlinkvaleur3;
    @Column(name = "EDITIONSNW1VALEUR4")
    private String editionsnw1valeur4;
    @Column(name = "EDITIONSNW2VALEUR4")
    private String editionsnw2valeur4;
    @Column(name = "EDITIONSNW3VALEUR4")
    private Integer editionsnw3valeur4;
    @Column(name = "EDITIONSNW4VALEUR4")
    private String editionsnw4valeur4;
    @Column(name = "EDITIONSNW5VALEUR4")
    private Integer editionsnw5valeur4;
    @Column(name = "EDITIONSNWLINKVALEUR4")
    private Integer editionsnwlinkvaleur4;
    @Column(name = "EDITIONSNW1VALEUR5")
    private String editionsnw1valeur5;
    @Column(name = "EDITIONSNW2VALEUR5")
    private String editionsnw2valeur5;
    @Column(name = "EDITIONSNW3VALEUR5")
    private Integer editionsnw3valeur5;
    @Column(name = "EDITIONSNW4VALEUR5")
    private String editionsnw4valeur5;
    @Column(name = "EDITIONSNW5VALEUR5")
    private Integer editionsnw5valeur5;
    @Column(name = "EDITIONSNWLINKVALEUR5")
    private Integer editionsnwlinkvaleur5;
    @Column(name = "EDITIONSNW1VALEUR6")
    private String editionsnw1valeur6;
    @Column(name = "EDITIONSNW2VALEUR6")
    private String editionsnw2valeur6;
    @Column(name = "EDITIONSNW3VALEUR6")
    private Integer editionsnw3valeur6;
    @Column(name = "EDITIONSNW4VALEUR6")
    private String editionsnw4valeur6;
    @Column(name = "EDITIONSNW5VALEUR6")
    private Integer editionsnw5valeur6;
    @Column(name = "EDITIONSNWLINKVALEUR6")
    private Integer editionsnwlinkvaleur6;
    @Column(name = "EDITIONSNW1VALEUR7")
    private String editionsnw1valeur7;
    @Column(name = "EDITIONSNW2VALEUR7")
    private String editionsnw2valeur7;
    @Column(name = "EDITIONSNW3VALEUR7")
    private Integer editionsnw3valeur7;
    @Column(name = "EDITIONSNW4VALEUR7")
    private String editionsnw4valeur7;
    @Column(name = "EDITIONSNW5VALEUR7")
    private Integer editionsnw5valeur7;
    @Column(name = "EDITIONSNWLINKVALEUR7")
    private Integer editionsnwlinkvaleur7;
    @Column(name = "EDITIONSNW1VALEUR8")
    private String editionsnw1valeur8;
    @Column(name = "EDITIONSNW2VALEUR8")
    private String editionsnw2valeur8;
    @Column(name = "EDITIONSNW3VALEUR8")
    private Integer editionsnw3valeur8;
    @Column(name = "EDITIONSNW4VALEUR8")
    private String editionsnw4valeur8;
    @Column(name = "EDITIONSNW5VALEUR8")
    private String editionsnw5valeur8;
    @Column(name = "EDITIONSNWLINKVALEUR8")
    private Integer editionsnwlinkvaleur8;
    @Column(name = "EDITIONSNW1VALEUR9")
    private Integer editionsnw1valeur9;
    @Column(name = "EDITIONSNW2VALEUR9")
    private Integer editionsnw2valeur9;
    @Column(name = "EDITIONSNW3VALEUR9")
    private Integer editionsnw3valeur9;
    @Column(name = "EDITIONSNW4VALEUR9")
    private Integer editionsnw4valeur9;
    @Column(name = "EDITIONSNW5VALEUR9")
    private Integer editionsnw5valeur9;
    @Column(name = "EDITIONSNWLINKVALEUR9")
    private Integer editionsnwlinkvaleur9;
    @Column(name = "EDITIONSNW1VALEUR10")
    private Integer editionsnw1valeur10;
    @Column(name = "EDITIONSNW2VALEUR10")
    private Integer editionsnw2valeur10;
    @Column(name = "EDITIONSNW3VALEUR10")
    private Integer editionsnw3valeur10;
    @Column(name = "EDITIONSNW4VALEUR10")
    private Integer editionsnw4valeur10;
    @Column(name = "EDITIONSNW5VALEUR10")
    private Integer editionsnw5valeur10;
    @Column(name = "EDITIONSNWLINKVALEUR10")
    private Integer editionsnwlinkvaleur10;
    @Column(name = "EDITIONSNW1VALEUR11")
    private Integer editionsnw1valeur11;
    @Column(name = "EDITIONSNW2VALEUR11")
    private Integer editionsnw2valeur11;
    @Column(name = "EDITIONSNW3VALEUR11")
    private Integer editionsnw3valeur11;
    @Column(name = "EDITIONSNW4VALEUR11")
    private Integer editionsnw4valeur11;
    @Column(name = "EDITIONSNW5VALEUR11")
    private Integer editionsnw5valeur11;
    @Column(name = "EDITIONSNWLINKVALEUR11")
    private Integer editionsnwlinkvaleur11;
    @Column(name = "EDITIONSNW1VALEUR12")
    private Integer editionsnw1valeur12;
    @Column(name = "EDITIONSNW2VALEUR12")
    private Integer editionsnw2valeur12;
    @Column(name = "EDITIONSNW3VALEUR12")
    private Integer editionsnw3valeur12;
    @Column(name = "EDITIONSNW4VALEUR12")
    private Integer editionsnw4valeur12;
    @Column(name = "EDITIONSNW5VALEUR12")
    private Integer editionsnw5valeur12;
    @Column(name = "EDITIONSNWLINKVALEUR12")
    private Integer editionsnwlinkvaleur12;
    @Column(name = "EDITIONSNW1VALEUR13")
    private Integer editionsnw1valeur13;
    @Column(name = "EDITIONSNW2VALEUR13")
    private Integer editionsnw2valeur13;
    @Column(name = "EDITIONSNW3VALEUR13")
    private Integer editionsnw3valeur13;
    @Column(name = "EDITIONSNW4VALEUR13")
    private Integer editionsnw4valeur13;
    @Column(name = "EDITIONSNW5VALEUR13")
    private Integer editionsnw5valeur13;
    @Column(name = "EDITIONSNWLINKVALEUR13")
    private Integer editionsnwlinkvaleur13;
    @Column(name = "EDITIONSNW1VALEUR14")
    private Integer editionsnw1valeur14;
    @Column(name = "EDITIONSNW2VALEUR14")
    private Integer editionsnw2valeur14;
    @Column(name = "EDITIONSNW3VALEUR14")
    private Integer editionsnw3valeur14;
    @Column(name = "EDITIONSNW4VALEUR14")
    private Integer editionsnw4valeur14;
    @Column(name = "EDITIONSNW5VALEUR14")
    private Integer editionsnw5valeur14;
    @Column(name = "EDITIONSNWLINKVALEUR14")
    private Integer editionsnwlinkvaleur14;
    @Column(name = "EDITIONSNW1VALEUR15")
    private Integer editionsnw1valeur15;
    @Column(name = "EDITIONSNW2VALEUR15")
    private Integer editionsnw2valeur15;
    @Column(name = "EDITIONSNW3VALEUR15")
    private Integer editionsnw3valeur15;
    @Column(name = "EDITIONSNW4VALEUR15")
    private Integer editionsnw4valeur15;
    @Column(name = "EDITIONSNW5VALEUR15")
    private Integer editionsnw5valeur15;
    @Column(name = "EDITIONSNWLINKVALEUR15")
    private Integer editionsnwlinkvaleur15;
    @Column(name = "EDITIONSNW1VALEUR16")
    private Integer editionsnw1valeur16;
    @Column(name = "EDITIONSNW2VALEUR16")
    private Integer editionsnw2valeur16;
    @Column(name = "EDITIONSNW3VALEUR16")
    private Integer editionsnw3valeur16;
    @Column(name = "EDITIONSNW4VALEUR16")
    private Integer editionsnw4valeur16;
    @Column(name = "EDITIONSNW5VALEUR16")
    private Integer editionsnw5valeur16;
    @Column(name = "EDITIONSNWLINKVALEUR16")
    private Integer editionsnwlinkvaleur16;
    @Column(name = "EDITIONSNW1VALEUR17")
    private Integer editionsnw1valeur17;
    @Column(name = "EDITIONSNW2VALEUR17")
    private Integer editionsnw2valeur17;
    @Column(name = "EDITIONSNW3VALEUR17")
    private Integer editionsnw3valeur17;
    @Column(name = "EDITIONSNW4VALEUR17")
    private Integer editionsnw4valeur17;
    @Column(name = "EDITIONSNW5VALEUR17")
    private Integer editionsnw5valeur17;
    @Column(name = "EDITIONSNWLINKVALEUR17")
    private Integer editionsnwlinkvaleur17;
    @Column(name = "EDITIONSNW1VALEUR18")
    private Integer editionsnw1valeur18;
    @Column(name = "EDITIONSNW2VALEUR18")
    private Integer editionsnw2valeur18;
    @Column(name = "EDITIONSNW3VALEUR18")
    private Integer editionsnw3valeur18;
    @Column(name = "EDITIONSNW4VALEUR18")
    private Integer editionsnw4valeur18;
    @Column(name = "EDITIONSNW5VALEUR18")
    private Integer editionsnw5valeur18;
    @Column(name = "EDITIONSNWLINKVALEUR18")
    private Integer editionsnwlinkvaleur18;
    @Column(name = "EDITIONSNW1VALEUR19")
    private Integer editionsnw1valeur19;
    @Column(name = "EDITIONSNW2VALEUR19")
    private Integer editionsnw2valeur19;
    @Column(name = "EDITIONSNW3VALEUR19")
    private Integer editionsnw3valeur19;
    @Column(name = "EDITIONSNW4VALEUR19")
    private Integer editionsnw4valeur19;
    @Column(name = "EDITIONSNW5VALEUR19")
    private Integer editionsnw5valeur19;
    @Column(name = "EDITIONSNWLINKVALEUR19")
    private Integer editionsnwlinkvaleur19;
    @Column(name = "EDITIONSNW1VALEUR20")
    private Integer editionsnw1valeur20;
    @Column(name = "EDITIONSNW2VALEUR20")
    private Integer editionsnw2valeur20;
    @Column(name = "EDITIONSNW3VALEUR20")
    private Integer editionsnw3valeur20;
    @Column(name = "EDITIONSNW4VALEUR20")
    private Integer editionsnw4valeur20;
    @Column(name = "EDITIONSNW5VALEUR20")
    private Integer editionsnw5valeur20;
    @Column(name = "EDITIONSNWLINKVALEUR20")
    private Integer editionsnwlinkvaleur20;
    @Column(name = "ETUDESNW1VALEUR1")
    private String etudesnw1valeur1;
    @Column(name = "ETUDESNW2VALEUR1")
    private String etudesnw2valeur1;
    @Column(name = "ETUDESNW3VALEUR1")
    private Integer etudesnw3valeur1;
    @Column(name = "ETUDESNW4VALEUR1")
    private String etudesnw4valeur1;
    @Column(name = "ETUDESNW5VALEUR1")
    private String etudesnw5valeur1;
    @Column(name = "ETUDESNWLINKVALEUR1")
    private String etudesnwlinkvaleur1;
    @Column(name = "ETUDESNW1VALEUR2")
    private String etudesnw1valeur2;
    @Column(name = "ETUDESNW2VALEUR2")
    private String etudesnw2valeur2;
    @Column(name = "ETUDESNW3VALEUR2")
    private Integer etudesnw3valeur2;
    @Column(name = "ETUDESNW4VALEUR2")
    private String etudesnw4valeur2;
    @Column(name = "ETUDESNW5VALEUR2")
    private String etudesnw5valeur2;
    @Column(name = "ETUDESNWLINKVALEUR2")
    private Integer etudesnwlinkvaleur2;
    @Column(name = "ETUDESNW1VALEUR3")
    private String etudesnw1valeur3;
    @Column(name = "ETUDESNW2VALEUR3")
    private String etudesnw2valeur3;
    @Column(name = "ETUDESNW3VALEUR3")
    private Integer etudesnw3valeur3;
    @Column(name = "ETUDESNW4VALEUR3")
    private String etudesnw4valeur3;
    @Column(name = "ETUDESNW5VALEUR3")
    private Integer etudesnw5valeur3;
    @Column(name = "ETUDESNWLINKVALEUR3")
    private Integer etudesnwlinkvaleur3;
    @Column(name = "ETUDESNW1VALEUR4")
    private String etudesnw1valeur4;
    @Column(name = "ETUDESNW2VALEUR4")
    private String etudesnw2valeur4;
    @Column(name = "ETUDESNW3VALEUR4")
    private Integer etudesnw3valeur4;
    @Column(name = "ETUDESNW4VALEUR4")
    private String etudesnw4valeur4;
    @Column(name = "ETUDESNW5VALEUR4")
    private String etudesnw5valeur4;
    @Column(name = "ETUDESNWLINKVALEUR4")
    private Integer etudesnwlinkvaleur4;
    @Column(name = "ETUDESNW1VALEUR5")
    private String etudesnw1valeur5;
    @Column(name = "ETUDESNW2VALEUR5")
    private String etudesnw2valeur5;
    @Column(name = "ETUDESNW3VALEUR5")
    private Integer etudesnw3valeur5;
    @Column(name = "ETUDESNW4VALEUR5")
    private String etudesnw4valeur5;
    @Column(name = "ETUDESNW5VALEUR5")
    private Integer etudesnw5valeur5;
    @Column(name = "ETUDESNWLINKVALEUR5")
    private Integer etudesnwlinkvaleur5;
    @Column(name = "ETUDESNW1VALEUR6")
    private String etudesnw1valeur6;
    @Column(name = "ETUDESNW2VALEUR6")
    private String etudesnw2valeur6;
    @Column(name = "ETUDESNW3VALEUR6")
    private Integer etudesnw3valeur6;
    @Column(name = "ETUDESNW4VALEUR6")
    private String etudesnw4valeur6;
    @Column(name = "ETUDESNW5VALEUR6")
    private Integer etudesnw5valeur6;
    @Column(name = "ETUDESNWLINKVALEUR6")
    private Integer etudesnwlinkvaleur6;
    @Column(name = "ETUDESNW1VALEUR7")
    private String etudesnw1valeur7;
    @Column(name = "ETUDESNW2VALEUR7")
    private String etudesnw2valeur7;
    @Column(name = "ETUDESNW3VALEUR7")
    private Integer etudesnw3valeur7;
    @Column(name = "ETUDESNW4VALEUR7")
    private String etudesnw4valeur7;
    @Column(name = "ETUDESNW5VALEUR7")
    private Integer etudesnw5valeur7;
    @Column(name = "ETUDESNWLINKVALEUR7")
    private Integer etudesnwlinkvaleur7;
    @Column(name = "ETUDESNW1VALEUR8")
    private String etudesnw1valeur8;
    @Column(name = "ETUDESNW2VALEUR8")
    private String etudesnw2valeur8;
    @Column(name = "ETUDESNW3VALEUR8")
    private Integer etudesnw3valeur8;
    @Column(name = "ETUDESNW4VALEUR8")
    private String etudesnw4valeur8;
    @Column(name = "ETUDESNW5VALEUR8")
    private Integer etudesnw5valeur8;
    @Column(name = "ETUDESNWLINKVALEUR8")
    private Integer etudesnwlinkvaleur8;
    @Column(name = "ETUDESNW1VALEUR9")
    private String etudesnw1valeur9;
    @Column(name = "ETUDESNW2VALEUR9")
    private String etudesnw2valeur9;
    @Column(name = "ETUDESNW3VALEUR9")
    private Integer etudesnw3valeur9;
    @Column(name = "ETUDESNW4VALEUR9")
    private String etudesnw4valeur9;
    @Column(name = "ETUDESNW5VALEUR9")
    private Integer etudesnw5valeur9;
    @Column(name = "ETUDESNWLINKVALEUR9")
    private Integer etudesnwlinkvaleur9;
    @Column(name = "ETUDESNW1VALEUR10")
    private Integer etudesnw1valeur10;
    @Column(name = "ETUDESNW2VALEUR10")
    private Integer etudesnw2valeur10;
    @Column(name = "ETUDESNW3VALEUR10")
    private Integer etudesnw3valeur10;
    @Column(name = "ETUDESNW4VALEUR10")
    private Integer etudesnw4valeur10;
    @Column(name = "ETUDESNW5VALEUR10")
    private Integer etudesnw5valeur10;
    @Column(name = "ETUDESNWLINKVALEUR10")
    private Integer etudesnwlinkvaleur10;
    @Column(name = "ETUDESNW1VALEUR11")
    private Integer etudesnw1valeur11;
    @Column(name = "ETUDESNW2VALEUR11")
    private Integer etudesnw2valeur11;
    @Column(name = "ETUDESNW3VALEUR11")
    private Integer etudesnw3valeur11;
    @Column(name = "ETUDESNW4VALEUR11")
    private Integer etudesnw4valeur11;
    @Column(name = "ETUDESNW5VALEUR11")
    private Integer etudesnw5valeur11;
    @Column(name = "ETUDESNWLINKVALEUR11")
    private Integer etudesnwlinkvaleur11;
    @Column(name = "ETUDESNW1VALEUR12")
    private Integer etudesnw1valeur12;
    @Column(name = "ETUDESNW2VALEUR12")
    private Integer etudesnw2valeur12;
    @Column(name = "ETUDESNW3VALEUR12")
    private Integer etudesnw3valeur12;
    @Column(name = "ETUDESNW4VALEUR12")
    private Integer etudesnw4valeur12;
    @Column(name = "ETUDESNW5VALEUR12")
    private Integer etudesnw5valeur12;
    @Column(name = "ETUDESNWLINKVALEUR12")
    private Integer etudesnwlinkvaleur12;
    @Column(name = "ETUDESNW1VALEUR13")
    private Integer etudesnw1valeur13;
    @Column(name = "ETUDESNW2VALEUR13")
    private Integer etudesnw2valeur13;
    @Column(name = "ETUDESNW3VALEUR13")
    private Integer etudesnw3valeur13;
    @Column(name = "ETUDESNW4VALEUR13")
    private Integer etudesnw4valeur13;
    @Column(name = "ETUDESNW5VALEUR13")
    private Integer etudesnw5valeur13;
    @Column(name = "ETUDESNWLINKVALEUR13")
    private Integer etudesnwlinkvaleur13;
    @Column(name = "ETUDESNW1VALEUR14")
    private Integer etudesnw1valeur14;
    @Column(name = "ETUDESNW2VALEUR14")
    private Integer etudesnw2valeur14;
    @Column(name = "ETUDESNW3VALEUR14")
    private Integer etudesnw3valeur14;
    @Column(name = "ETUDESNW4VALEUR14")
    private Integer etudesnw4valeur14;
    @Column(name = "ETUDESNW5VALEUR14")
    private Integer etudesnw5valeur14;
    @Column(name = "ETUDESNWLINKVALEUR14")
    private Integer etudesnwlinkvaleur14;
    @Column(name = "ETUDESNW1VALEUR15")
    private Integer etudesnw1valeur15;
    @Column(name = "ETUDESNW2VALEUR15")
    private Integer etudesnw2valeur15;
    @Column(name = "ETUDESNW3VALEUR15")
    private Integer etudesnw3valeur15;
    @Column(name = "ETUDESNW4VALEUR15")
    private Integer etudesnw4valeur15;
    @Column(name = "ETUDESNW5VALEUR15")
    private Integer etudesnw5valeur15;
    @Column(name = "ETUDESNWLINKVALEUR15")
    private Integer etudesnwlinkvaleur15;
    @Column(name = "ETUDESNW1VALEUR16")
    private Integer etudesnw1valeur16;
    @Column(name = "ETUDESNW2VALEUR16")
    private Integer etudesnw2valeur16;
    @Column(name = "ETUDESNW3VALEUR16")
    private Integer etudesnw3valeur16;
    @Column(name = "ETUDESNW4VALEUR16")
    private Integer etudesnw4valeur16;
    @Column(name = "ETUDESNW5VALEUR16")
    private Integer etudesnw5valeur16;
    @Column(name = "ETUDESNWLINKVALEUR16")
    private Integer etudesnwlinkvaleur16;
    @Column(name = "ETUDESNW1VALEUR17")
    private Integer etudesnw1valeur17;
    @Column(name = "ETUDESNW2VALEUR17")
    private Integer etudesnw2valeur17;
    @Column(name = "ETUDESNW3VALEUR17")
    private Integer etudesnw3valeur17;
    @Column(name = "ETUDESNW4VALEUR17")
    private Integer etudesnw4valeur17;
    @Column(name = "ETUDESNW5VALEUR17")
    private Integer etudesnw5valeur17;
    @Column(name = "ETUDESNWLINKVALEUR17")
    private Integer etudesnwlinkvaleur17;
    @Column(name = "ETUDESNW1VALEUR18")
    private Integer etudesnw1valeur18;
    @Column(name = "ETUDESNW2VALEUR18")
    private Integer etudesnw2valeur18;
    @Column(name = "ETUDESNW3VALEUR18")
    private Integer etudesnw3valeur18;
    @Column(name = "ETUDESNW4VALEUR18")
    private Integer etudesnw4valeur18;
    @Column(name = "ETUDESNW5VALEUR18")
    private Integer etudesnw5valeur18;
    @Column(name = "ETUDESNWLINKVALEUR18")
    private Integer etudesnwlinkvaleur18;
    @Column(name = "ETUDESNW1VALEUR19")
    private Integer etudesnw1valeur19;
    @Column(name = "ETUDESNW2VALEUR19")
    private Integer etudesnw2valeur19;
    @Column(name = "ETUDESNW3VALEUR19")
    private Integer etudesnw3valeur19;
    @Column(name = "ETUDESNW4VALEUR19")
    private Integer etudesnw4valeur19;
    @Column(name = "ETUDESNW5VALEUR19")
    private Integer etudesnw5valeur19;
    @Column(name = "ETUDESNWLINKVALEUR19")
    private Integer etudesnwlinkvaleur19;
    @Column(name = "ETUDESNW1VALEUR20")
    private Integer etudesnw1valeur20;
    @Column(name = "ETUDESNW2VALEUR20")
    private Integer etudesnw2valeur20;
    @Column(name = "ETUDESNW3VALEUR20")
    private Integer etudesnw3valeur20;
    @Column(name = "ETUDESNW4VALEUR20")
    private Integer etudesnw4valeur20;
    @Column(name = "ETUDESNW5VALEUR20")
    private Integer etudesnw5valeur20;
    @Column(name = "ETUDESNWLINKVALEUR20")
    private Integer etudesnwlinkvaleur20;
    @Column(name = "EDITIONDLMD1VALEUR1")
    private String editiondlmd1valeur1;
    @Column(name = "EDITIONDLMD2VALEUR1")
    private String editiondlmd2valeur1;
    @Column(name = "EDITIONDLMD3VALEUR1")
    private String editiondlmd3valeur1;
    @Column(name = "EDITIONDLMD4VALEUR1")
    private String editiondlmd4valeur1;
    @Column(name = "EDITIONDLMD5VALEUR1")
    private Integer editiondlmd5valeur1;
    @Column(name = "EDITIONDLMDLINKVALEUR1")
    private Integer editiondlmdlinkvaleur1;
    @Column(name = "ORIGINAL1VALEUR1")
    private String original1valeur1;
    @Column(name = "ORIGINAL2VALEUR1")
    private String original2valeur1;
    @Column(name = "ORIGINAL3VALEUR1")
    private String original3valeur1;
    @Column(name = "ORIGINAL1VALEUR2")
    private Integer original1valeur2;
    @Column(name = "ORIGINAL2VALEUR2")
    private Integer original2valeur2;
    @Column(name = "ORIGINAL3VALEUR2")
    private Integer original3valeur2;
    @Column(name = "ORIGINAL1VALEUR3")
    private Integer original1valeur3;
    @Column(name = "ORIGINAL2VALEUR3")
    private Integer original2valeur3;
    @Column(name = "ORIGINAL3VALEUR3")
    private Integer original3valeur3;
    @Column(name = "COPIES1VALEUR1")
    private String copies1valeur1;
    @Column(name = "COPIES2VALEUR1")
    private String copies2valeur1;
    @Column(name = "COPIES3VALEUR1")
    private String copies3valeur1;
    @Column(name = "COPIES4VALEUR1")
    private String copies4valeur1;
    @Column(name = "COPIES5VALEUR1")
    private Integer copies5valeur1;
    @Column(name = "COPIES1VALEUR2")
    private String copies1valeur2;
    @Column(name = "COPIES2VALEUR2")
    private String copies2valeur2;
    @Column(name = "COPIES3VALEUR2")
    private String copies3valeur2;
    @Column(name = "COPIES4VALEUR2")
    private String copies4valeur2;
    @Column(name = "COPIES5VALEUR2")
    private Integer copies5valeur2;
    @Column(name = "COPIES1VALEUR3")
    private String copies1valeur3;
    @Column(name = "COPIES2VALEUR3")
    private String copies2valeur3;
    @Column(name = "COPIES3VALEUR3")
    private String copies3valeur3;
    @Column(name = "COPIES4VALEUR3")
    private String copies4valeur3;
    @Column(name = "COPIES5VALEUR3")
    private Integer copies5valeur3;
    @Column(name = "COPIES1VALEUR4")
    private String copies1valeur4;
    @Column(name = "COPIES2VALEUR4")
    private String copies2valeur4;
    @Column(name = "COPIES3VALEUR4")
    private String copies3valeur4;
    @Column(name = "COPIES4VALEUR4")
    private String copies4valeur4;
    @Column(name = "COPIES5VALEUR4")
    private Integer copies5valeur4;
    @Column(name = "COPIES1VALEUR5")
    private String copies1valeur5;
    @Column(name = "COPIES2VALEUR5")
    private String copies2valeur5;
    @Column(name = "COPIES3VALEUR5")
    private String copies3valeur5;
    @Column(name = "COPIES4VALEUR5")
    private String copies4valeur5;
    @Column(name = "COPIES5VALEUR5")
    private Integer copies5valeur5;
    @Column(name = "COPIES1VALEUR6")
    private String copies1valeur6;
    @Column(name = "COPIES2VALEUR6")
    private String copies2valeur6;
    @Column(name = "COPIES3VALEUR6")
    private String copies3valeur6;
    @Column(name = "COPIES4VALEUR6")
    private String copies4valeur6;
    @Column(name = "COPIES5VALEUR6")
    private Integer copies5valeur6;
    @Column(name = "COPIES1VALEUR7")
    private Integer copies1valeur7;
    @Column(name = "COPIES2VALEUR7")
    private Integer copies2valeur7;
    @Column(name = "COPIES3VALEUR7")
    private Integer copies3valeur7;
    @Column(name = "COPIES4VALEUR7")
    private Integer copies4valeur7;
    @Column(name = "COPIES5VALEUR7")
    private Integer copies5valeur7;
    @Column(name = "COPIES1VALEUR8")
    private Integer copies1valeur8;
    @Column(name = "COPIES2VALEUR8")
    private Integer copies2valeur8;
    @Column(name = "COPIES3VALEUR8")
    private Integer copies3valeur8;
    @Column(name = "COPIES4VALEUR8")
    private Integer copies4valeur8;
    @Column(name = "COPIES5VALEUR8")
    private Integer copies5valeur8;
    @Column(name = "COPIES1VALEUR9")
    private Integer copies1valeur9;
    @Column(name = "COPIES2VALEUR9")
    private Integer copies2valeur9;
    @Column(name = "COPIES3VALEUR9")
    private Integer copies3valeur9;
    @Column(name = "COPIES4VALEUR9")
    private Integer copies4valeur9;
    @Column(name = "COPIES5VALEUR9")
    private Integer copies5valeur9;
    @Column(name = "COPIES1VALEUR10")
    private Integer copies1valeur10;
    @Column(name = "COPIES2VALEUR10")
    private Integer copies2valeur10;
    @Column(name = "COPIES3VALEUR10")
    private Integer copies3valeur10;
    @Column(name = "COPIES4VALEUR10")
    private Integer copies4valeur10;
    @Column(name = "COPIES5VALEUR10")
    private Integer copies5valeur10;
    @Column(name = "COPIES1VALEUR11")
    private Integer copies1valeur11;
    @Column(name = "COPIES2VALEUR11")
    private Integer copies2valeur11;
    @Column(name = "COPIES3VALEUR11")
    private Integer copies3valeur11;
    @Column(name = "COPIES4VALEUR11")
    private Integer copies4valeur11;
    @Column(name = "COPIES5VALEUR11")
    private Integer copies5valeur11;
    @Column(name = "COPIES1VALEUR12")
    private Integer copies1valeur12;
    @Column(name = "COPIES2VALEUR12")
    private Integer copies2valeur12;
    @Column(name = "COPIES3VALEUR12")
    private Integer copies3valeur12;
    @Column(name = "COPIES4VALEUR12")
    private Integer copies4valeur12;
    @Column(name = "COPIES5VALEUR12")
    private Integer copies5valeur12;
    @Column(name = "COPIES1VALEUR13")
    private Integer copies1valeur13;
    @Column(name = "COPIES2VALEUR13")
    private Integer copies2valeur13;
    @Column(name = "COPIES3VALEUR13")
    private Integer copies3valeur13;
    @Column(name = "COPIES4VALEUR13")
    private Integer copies4valeur13;
    @Column(name = "COPIES1VALEUR14")
    private Integer copies1valeur14;
    @Column(name = "COPIES2VALEUR14")
    private Integer copies2valeur14;
    @Column(name = "COPIES3VALEUR14")
    private Integer copies3valeur14;
    @Column(name = "COPIES4VALEUR14")
    private Integer copies4valeur14;
    @Column(name = "COPIES5VALEUR14")
    private Integer copies5valeur14;
    @Column(name = "TEXTE")
    private String texte;

    public Contents() {
    }

    public Contents(Integer numerowauters) {
        this.numerowauters = numerowauters;
    }

    public Integer getNumerowauters() {
        return numerowauters;
    }

    public void setNumerowauters(Integer numerowauters) {
        this.numerowauters = numerowauters;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getVeracite() {
        return veracite;
    }

    public void setVeracite(String veracite) {
        this.veracite = veracite;
    }

    public Integer getDatemillesimevaleur1() {
        return datemillesimevaleur1;
    }

    public void setDatemillesimevaleur1(Integer datemillesimevaleur1) {
        this.datemillesimevaleur1 = datemillesimevaleur1;
    }

    public Integer getDatemoisvaleur1() {
        return datemoisvaleur1;
    }

    public void setDatemoisvaleur1(Integer datemoisvaleur1) {
        this.datemoisvaleur1 = datemoisvaleur1;
    }

    public Integer getDatejourvaleur1() {
        return datejourvaleur1;
    }

    public void setDatejourvaleur1(Integer datejourvaleur1) {
        this.datejourvaleur1 = datejourvaleur1;
    }

    public Integer getDatecodesvaleur1() {
        return datecodesvaleur1;
    }

    public void setDatecodesvaleur1(Integer datecodesvaleur1) {
        this.datecodesvaleur1 = datecodesvaleur1;
    }

    public String getDatejustificationsvaleur1() {
        return datejustificationsvaleur1;
    }

    public void setDatejustificationsvaleur1(String datejustificationsvaleur1) {
        this.datejustificationsvaleur1 = datejustificationsvaleur1;
    }

    public Integer getMixdat1valeur1() {
        return mixdat1valeur1;
    }

    public void setMixdat1valeur1(Integer mixdat1valeur1) {
        this.mixdat1valeur1 = mixdat1valeur1;
    }

    public Integer getMixdat2valeur1() {
        return mixdat2valeur1;
    }

    public void setMixdat2valeur1(Integer mixdat2valeur1) {
        this.mixdat2valeur1 = mixdat2valeur1;
    }

    public Integer getMixdat3valeur1() {
        return mixdat3valeur1;
    }

    public void setMixdat3valeur1(Integer mixdat3valeur1) {
        this.mixdat3valeur1 = mixdat3valeur1;
    }

    public Integer getMixdatccodevaleur1() {
        return mixdatccodevaleur1;
    }

    public void setMixdatccodevaleur1(Integer mixdatccodevaleur1) {
        this.mixdatccodevaleur1 = mixdatccodevaleur1;
    }

    public String getMixdatjusvaleur1() {
        return mixdatjusvaleur1;
    }

    public void setMixdatjusvaleur1(String mixdatjusvaleur1) {
        this.mixdatjusvaleur1 = mixdatjusvaleur1;
    }

    public Integer getMixdat1valeur2() {
        return mixdat1valeur2;
    }

    public void setMixdat1valeur2(Integer mixdat1valeur2) {
        this.mixdat1valeur2 = mixdat1valeur2;
    }

    public Integer getMixdat2valeur2() {
        return mixdat2valeur2;
    }

    public void setMixdat2valeur2(Integer mixdat2valeur2) {
        this.mixdat2valeur2 = mixdat2valeur2;
    }

    public Integer getMixdat3valeur2() {
        return mixdat3valeur2;
    }

    public void setMixdat3valeur2(Integer mixdat3valeur2) {
        this.mixdat3valeur2 = mixdat3valeur2;
    }

    public Integer getMixdatccodevaleur2() {
        return mixdatccodevaleur2;
    }

    public void setMixdatccodevaleur2(Integer mixdatccodevaleur2) {
        this.mixdatccodevaleur2 = mixdatccodevaleur2;
    }

    public String getMixdatjusvaleur2() {
        return mixdatjusvaleur2;
    }

    public void setMixdatjusvaleur2(String mixdatjusvaleur2) {
        this.mixdatjusvaleur2 = mixdatjusvaleur2;
    }

    public Integer getMixdat1valeur3() {
        return mixdat1valeur3;
    }

    public void setMixdat1valeur3(Integer mixdat1valeur3) {
        this.mixdat1valeur3 = mixdat1valeur3;
    }

    public Integer getMixdat2valeur3() {
        return mixdat2valeur3;
    }

    public void setMixdat2valeur3(Integer mixdat2valeur3) {
        this.mixdat2valeur3 = mixdat2valeur3;
    }

    public Integer getMixdat3valeur3() {
        return mixdat3valeur3;
    }

    public void setMixdat3valeur3(Integer mixdat3valeur3) {
        this.mixdat3valeur3 = mixdat3valeur3;
    }

    public Integer getMixdatccodevaleur3() {
        return mixdatccodevaleur3;
    }

    public void setMixdatccodevaleur3(Integer mixdatccodevaleur3) {
        this.mixdatccodevaleur3 = mixdatccodevaleur3;
    }

    public String getMixdatjusvaleur3() {
        return mixdatjusvaleur3;
    }

    public void setMixdatjusvaleur3(String mixdatjusvaleur3) {
        this.mixdatjusvaleur3 = mixdatjusvaleur3;
    }

    public Integer getMixdat1valeur4() {
        return mixdat1valeur4;
    }

    public void setMixdat1valeur4(Integer mixdat1valeur4) {
        this.mixdat1valeur4 = mixdat1valeur4;
    }

    public Integer getMixdat2valeur4() {
        return mixdat2valeur4;
    }

    public void setMixdat2valeur4(Integer mixdat2valeur4) {
        this.mixdat2valeur4 = mixdat2valeur4;
    }

    public Integer getMixdat3valeur4() {
        return mixdat3valeur4;
    }

    public void setMixdat3valeur4(Integer mixdat3valeur4) {
        this.mixdat3valeur4 = mixdat3valeur4;
    }

    public Integer getMixdatccodevaleur4() {
        return mixdatccodevaleur4;
    }

    public void setMixdatccodevaleur4(Integer mixdatccodevaleur4) {
        this.mixdatccodevaleur4 = mixdatccodevaleur4;
    }

    public String getMixdatjusvaleur4() {
        return mixdatjusvaleur4;
    }

    public void setMixdatjusvaleur4(String mixdatjusvaleur4) {
        this.mixdatjusvaleur4 = mixdatjusvaleur4;
    }

    public Integer getMixdat1valeur5() {
        return mixdat1valeur5;
    }

    public void setMixdat1valeur5(Integer mixdat1valeur5) {
        this.mixdat1valeur5 = mixdat1valeur5;
    }

    public Integer getMixdat2valeur5() {
        return mixdat2valeur5;
    }

    public void setMixdat2valeur5(Integer mixdat2valeur5) {
        this.mixdat2valeur5 = mixdat2valeur5;
    }

    public Integer getMixdat3valeur5() {
        return mixdat3valeur5;
    }

    public void setMixdat3valeur5(Integer mixdat3valeur5) {
        this.mixdat3valeur5 = mixdat3valeur5;
    }

    public Integer getMixdatccodevaleur5() {
        return mixdatccodevaleur5;
    }

    public void setMixdatccodevaleur5(Integer mixdatccodevaleur5) {
        this.mixdatccodevaleur5 = mixdatccodevaleur5;
    }

    public String getMixdatjusvaleur5() {
        return mixdatjusvaleur5;
    }

    public void setMixdatjusvaleur5(String mixdatjusvaleur5) {
        this.mixdatjusvaleur5 = mixdatjusvaleur5;
    }

    public Integer getMixdat1valeur6() {
        return mixdat1valeur6;
    }

    public void setMixdat1valeur6(Integer mixdat1valeur6) {
        this.mixdat1valeur6 = mixdat1valeur6;
    }

    public Integer getMixdat2valeur6() {
        return mixdat2valeur6;
    }

    public void setMixdat2valeur6(Integer mixdat2valeur6) {
        this.mixdat2valeur6 = mixdat2valeur6;
    }

    public Integer getMixdat3valeur6() {
        return mixdat3valeur6;
    }

    public void setMixdat3valeur6(Integer mixdat3valeur6) {
        this.mixdat3valeur6 = mixdat3valeur6;
    }

    public Integer getMixdatccodevaleur6() {
        return mixdatccodevaleur6;
    }

    public void setMixdatccodevaleur6(Integer mixdatccodevaleur6) {
        this.mixdatccodevaleur6 = mixdatccodevaleur6;
    }

    public String getMixdatjusvaleur6() {
        return mixdatjusvaleur6;
    }

    public void setMixdatjusvaleur6(String mixdatjusvaleur6) {
        this.mixdatjusvaleur6 = mixdatjusvaleur6;
    }

    public Integer getMixdat1valeur7() {
        return mixdat1valeur7;
    }

    public void setMixdat1valeur7(Integer mixdat1valeur7) {
        this.mixdat1valeur7 = mixdat1valeur7;
    }

    public Integer getMixdat2valeur7() {
        return mixdat2valeur7;
    }

    public void setMixdat2valeur7(Integer mixdat2valeur7) {
        this.mixdat2valeur7 = mixdat2valeur7;
    }

    public Integer getMixdat3valeur7() {
        return mixdat3valeur7;
    }

    public void setMixdat3valeur7(Integer mixdat3valeur7) {
        this.mixdat3valeur7 = mixdat3valeur7;
    }

    public Integer getMixdatccodevaleur7() {
        return mixdatccodevaleur7;
    }

    public void setMixdatccodevaleur7(Integer mixdatccodevaleur7) {
        this.mixdatccodevaleur7 = mixdatccodevaleur7;
    }

    public String getMixdatjusvaleur7() {
        return mixdatjusvaleur7;
    }

    public void setMixdatjusvaleur7(String mixdatjusvaleur7) {
        this.mixdatjusvaleur7 = mixdatjusvaleur7;
    }

    public Integer getMixdat1valeur8() {
        return mixdat1valeur8;
    }

    public void setMixdat1valeur8(Integer mixdat1valeur8) {
        this.mixdat1valeur8 = mixdat1valeur8;
    }

    public Integer getMixdat2valeur8() {
        return mixdat2valeur8;
    }

    public void setMixdat2valeur8(Integer mixdat2valeur8) {
        this.mixdat2valeur8 = mixdat2valeur8;
    }

    public Integer getMixdat3valeur8() {
        return mixdat3valeur8;
    }

    public void setMixdat3valeur8(Integer mixdat3valeur8) {
        this.mixdat3valeur8 = mixdat3valeur8;
    }

    public Integer getMixdatccodevaleur8() {
        return mixdatccodevaleur8;
    }

    public void setMixdatccodevaleur8(Integer mixdatccodevaleur8) {
        this.mixdatccodevaleur8 = mixdatccodevaleur8;
    }

    public String getMixdatjusvaleur8() {
        return mixdatjusvaleur8;
    }

    public void setMixdatjusvaleur8(String mixdatjusvaleur8) {
        this.mixdatjusvaleur8 = mixdatjusvaleur8;
    }

    public Integer getMixdat1valeur9() {
        return mixdat1valeur9;
    }

    public void setMixdat1valeur9(Integer mixdat1valeur9) {
        this.mixdat1valeur9 = mixdat1valeur9;
    }

    public Integer getMixdat2valeur9() {
        return mixdat2valeur9;
    }

    public void setMixdat2valeur9(Integer mixdat2valeur9) {
        this.mixdat2valeur9 = mixdat2valeur9;
    }

    public Integer getMixdat3valeur9() {
        return mixdat3valeur9;
    }

    public void setMixdat3valeur9(Integer mixdat3valeur9) {
        this.mixdat3valeur9 = mixdat3valeur9;
    }

    public Integer getMixdatccodevaleur9() {
        return mixdatccodevaleur9;
    }

    public void setMixdatccodevaleur9(Integer mixdatccodevaleur9) {
        this.mixdatccodevaleur9 = mixdatccodevaleur9;
    }

    public String getMixdatjusvaleur9() {
        return mixdatjusvaleur9;
    }

    public void setMixdatjusvaleur9(String mixdatjusvaleur9) {
        this.mixdatjusvaleur9 = mixdatjusvaleur9;
    }

    public Integer getMixdat1valeur10() {
        return mixdat1valeur10;
    }

    public void setMixdat1valeur10(Integer mixdat1valeur10) {
        this.mixdat1valeur10 = mixdat1valeur10;
    }

    public Integer getMixdat2valeur10() {
        return mixdat2valeur10;
    }

    public void setMixdat2valeur10(Integer mixdat2valeur10) {
        this.mixdat2valeur10 = mixdat2valeur10;
    }

    public Integer getMixdat3valeur10() {
        return mixdat3valeur10;
    }

    public void setMixdat3valeur10(Integer mixdat3valeur10) {
        this.mixdat3valeur10 = mixdat3valeur10;
    }

    public Integer getMixdatccodevaleur10() {
        return mixdatccodevaleur10;
    }

    public void setMixdatccodevaleur10(Integer mixdatccodevaleur10) {
        this.mixdatccodevaleur10 = mixdatccodevaleur10;
    }

    public String getMixdatjusvaleur10() {
        return mixdatjusvaleur10;
    }

    public void setMixdatjusvaleur10(String mixdatjusvaleur10) {
        this.mixdatjusvaleur10 = mixdatjusvaleur10;
    }

    public Integer getMixdat1valeur11() {
        return mixdat1valeur11;
    }

    public void setMixdat1valeur11(Integer mixdat1valeur11) {
        this.mixdat1valeur11 = mixdat1valeur11;
    }

    public Integer getMixdat2valeur11() {
        return mixdat2valeur11;
    }

    public void setMixdat2valeur11(Integer mixdat2valeur11) {
        this.mixdat2valeur11 = mixdat2valeur11;
    }

    public Integer getMixdat3valeur11() {
        return mixdat3valeur11;
    }

    public void setMixdat3valeur11(Integer mixdat3valeur11) {
        this.mixdat3valeur11 = mixdat3valeur11;
    }

    public Integer getMixdatccodevaleur11() {
        return mixdatccodevaleur11;
    }

    public void setMixdatccodevaleur11(Integer mixdatccodevaleur11) {
        this.mixdatccodevaleur11 = mixdatccodevaleur11;
    }

    public String getMixdatjusvaleur11() {
        return mixdatjusvaleur11;
    }

    public void setMixdatjusvaleur11(String mixdatjusvaleur11) {
        this.mixdatjusvaleur11 = mixdatjusvaleur11;
    }

    public Integer getMixdat1valeur12() {
        return mixdat1valeur12;
    }

    public void setMixdat1valeur12(Integer mixdat1valeur12) {
        this.mixdat1valeur12 = mixdat1valeur12;
    }

    public Integer getMixdat2valeur12() {
        return mixdat2valeur12;
    }

    public void setMixdat2valeur12(Integer mixdat2valeur12) {
        this.mixdat2valeur12 = mixdat2valeur12;
    }

    public Integer getMixdat3valeur12() {
        return mixdat3valeur12;
    }

    public void setMixdat3valeur12(Integer mixdat3valeur12) {
        this.mixdat3valeur12 = mixdat3valeur12;
    }

    public Integer getMixdatccodevaleur12() {
        return mixdatccodevaleur12;
    }

    public void setMixdatccodevaleur12(Integer mixdatccodevaleur12) {
        this.mixdatccodevaleur12 = mixdatccodevaleur12;
    }

    public Integer getMixdatjusvaleur12() {
        return mixdatjusvaleur12;
    }

    public void setMixdatjusvaleur12(Integer mixdatjusvaleur12) {
        this.mixdatjusvaleur12 = mixdatjusvaleur12;
    }

    public Integer getMixdat1valeur13() {
        return mixdat1valeur13;
    }

    public void setMixdat1valeur13(Integer mixdat1valeur13) {
        this.mixdat1valeur13 = mixdat1valeur13;
    }

    public Integer getMixdat2valeur13() {
        return mixdat2valeur13;
    }

    public void setMixdat2valeur13(Integer mixdat2valeur13) {
        this.mixdat2valeur13 = mixdat2valeur13;
    }

    public Integer getMixdat3valeur13() {
        return mixdat3valeur13;
    }

    public void setMixdat3valeur13(Integer mixdat3valeur13) {
        this.mixdat3valeur13 = mixdat3valeur13;
    }

    public Integer getMixdatccodevaleur13() {
        return mixdatccodevaleur13;
    }

    public void setMixdatccodevaleur13(Integer mixdatccodevaleur13) {
        this.mixdatccodevaleur13 = mixdatccodevaleur13;
    }

    public Integer getMixdatjusvaleur13() {
        return mixdatjusvaleur13;
    }

    public void setMixdatjusvaleur13(Integer mixdatjusvaleur13) {
        this.mixdatjusvaleur13 = mixdatjusvaleur13;
    }

    public Integer getMixdat1valeur14() {
        return mixdat1valeur14;
    }

    public void setMixdat1valeur14(Integer mixdat1valeur14) {
        this.mixdat1valeur14 = mixdat1valeur14;
    }

    public Integer getMixdat2valeur14() {
        return mixdat2valeur14;
    }

    public void setMixdat2valeur14(Integer mixdat2valeur14) {
        this.mixdat2valeur14 = mixdat2valeur14;
    }

    public Integer getMixdat3valeur14() {
        return mixdat3valeur14;
    }

    public void setMixdat3valeur14(Integer mixdat3valeur14) {
        this.mixdat3valeur14 = mixdat3valeur14;
    }

    public Integer getMixdatccodevaleur14() {
        return mixdatccodevaleur14;
    }

    public void setMixdatccodevaleur14(Integer mixdatccodevaleur14) {
        this.mixdatccodevaleur14 = mixdatccodevaleur14;
    }

    public Integer getMixdatjusvaleur14() {
        return mixdatjusvaleur14;
    }

    public void setMixdatjusvaleur14(Integer mixdatjusvaleur14) {
        this.mixdatjusvaleur14 = mixdatjusvaleur14;
    }

    public String getAuteur1valeur1() {
        return auteur1valeur1;
    }

    public void setAuteur1valeur1(String auteur1valeur1) {
        this.auteur1valeur1 = auteur1valeur1;
    }

    public String getAuteur2valeur1() {
        return auteur2valeur1;
    }

    public void setAuteur2valeur1(String auteur2valeur1) {
        this.auteur2valeur1 = auteur2valeur1;
    }

    public Integer getAuteur1valeur2() {
        return auteur1valeur2;
    }

    public void setAuteur1valeur2(Integer auteur1valeur2) {
        this.auteur1valeur2 = auteur1valeur2;
    }

    public Integer getAuteur2valeur2() {
        return auteur2valeur2;
    }

    public void setAuteur2valeur2(Integer auteur2valeur2) {
        this.auteur2valeur2 = auteur2valeur2;
    }

    public Integer getAuteur1valeur3() {
        return auteur1valeur3;
    }

    public void setAuteur1valeur3(Integer auteur1valeur3) {
        this.auteur1valeur3 = auteur1valeur3;
    }

    public Integer getAuteur2valeur3() {
        return auteur2valeur3;
    }

    public void setAuteur2valeur3(Integer auteur2valeur3) {
        this.auteur2valeur3 = auteur2valeur3;
    }

    public Integer getAuteur1valeur4() {
        return auteur1valeur4;
    }

    public void setAuteur1valeur4(Integer auteur1valeur4) {
        this.auteur1valeur4 = auteur1valeur4;
    }

    public Integer getAuteur2valeur4() {
        return auteur2valeur4;
    }

    public void setAuteur2valeur4(Integer auteur2valeur4) {
        this.auteur2valeur4 = auteur2valeur4;
    }

    public Integer getAuteur1valeur5() {
        return auteur1valeur5;
    }

    public void setAuteur1valeur5(Integer auteur1valeur5) {
        this.auteur1valeur5 = auteur1valeur5;
    }

    public Integer getAuteur2valeur5() {
        return auteur2valeur5;
    }

    public void setAuteur2valeur5(Integer auteur2valeur5) {
        this.auteur2valeur5 = auteur2valeur5;
    }

    public Integer getAuteur1valeur6() {
        return auteur1valeur6;
    }

    public void setAuteur1valeur6(Integer auteur1valeur6) {
        this.auteur1valeur6 = auteur1valeur6;
    }

    public Integer getAuteur2valeur6() {
        return auteur2valeur6;
    }

    public void setAuteur2valeur6(Integer auteur2valeur6) {
        this.auteur2valeur6 = auteur2valeur6;
    }

    public Integer getAuteur1valeur7() {
        return auteur1valeur7;
    }

    public void setAuteur1valeur7(Integer auteur1valeur7) {
        this.auteur1valeur7 = auteur1valeur7;
    }

    public Integer getAuteur2valeur7() {
        return auteur2valeur7;
    }

    public void setAuteur2valeur7(Integer auteur2valeur7) {
        this.auteur2valeur7 = auteur2valeur7;
    }

    public Integer getAuteur1valeur8() {
        return auteur1valeur8;
    }

    public void setAuteur1valeur8(Integer auteur1valeur8) {
        this.auteur1valeur8 = auteur1valeur8;
    }

    public Integer getAuteur2valeur8() {
        return auteur2valeur8;
    }

    public void setAuteur2valeur8(Integer auteur2valeur8) {
        this.auteur2valeur8 = auteur2valeur8;
    }

    public Integer getAuteur1valeur9() {
        return auteur1valeur9;
    }

    public void setAuteur1valeur9(Integer auteur1valeur9) {
        this.auteur1valeur9 = auteur1valeur9;
    }

    public Integer getAuteur2valeur9() {
        return auteur2valeur9;
    }

    public void setAuteur2valeur9(Integer auteur2valeur9) {
        this.auteur2valeur9 = auteur2valeur9;
    }

    public Integer getAuteur1valeur10() {
        return auteur1valeur10;
    }

    public void setAuteur1valeur10(Integer auteur1valeur10) {
        this.auteur1valeur10 = auteur1valeur10;
    }

    public Integer getAuteur2valeur10() {
        return auteur2valeur10;
    }

    public void setAuteur2valeur10(Integer auteur2valeur10) {
        this.auteur2valeur10 = auteur2valeur10;
    }

    public Integer getAuteur1valeur11() {
        return auteur1valeur11;
    }

    public void setAuteur1valeur11(Integer auteur1valeur11) {
        this.auteur1valeur11 = auteur1valeur11;
    }

    public Integer getAuteur2valeur11() {
        return auteur2valeur11;
    }

    public void setAuteur2valeur11(Integer auteur2valeur11) {
        this.auteur2valeur11 = auteur2valeur11;
    }

    public Integer getAuteur1valeur12() {
        return auteur1valeur12;
    }

    public void setAuteur1valeur12(Integer auteur1valeur12) {
        this.auteur1valeur12 = auteur1valeur12;
    }

    public Integer getAuteur2valeur12() {
        return auteur2valeur12;
    }

    public void setAuteur2valeur12(Integer auteur2valeur12) {
        this.auteur2valeur12 = auteur2valeur12;
    }

    public String getDisposant1valeur1() {
        return disposant1valeur1;
    }

    public void setDisposant1valeur1(String disposant1valeur1) {
        this.disposant1valeur1 = disposant1valeur1;
    }

    public String getDisposant2valeur1() {
        return disposant2valeur1;
    }

    public void setDisposant2valeur1(String disposant2valeur1) {
        this.disposant2valeur1 = disposant2valeur1;
    }

    public Integer getDisposant1valeur2() {
        return disposant1valeur2;
    }

    public void setDisposant1valeur2(Integer disposant1valeur2) {
        this.disposant1valeur2 = disposant1valeur2;
    }

    public Integer getDisposant2valeur2() {
        return disposant2valeur2;
    }

    public void setDisposant2valeur2(Integer disposant2valeur2) {
        this.disposant2valeur2 = disposant2valeur2;
    }

    public Integer getDisposant1valeur3() {
        return disposant1valeur3;
    }

    public void setDisposant1valeur3(Integer disposant1valeur3) {
        this.disposant1valeur3 = disposant1valeur3;
    }

    public Integer getDisposant2valeur3() {
        return disposant2valeur3;
    }

    public void setDisposant2valeur3(Integer disposant2valeur3) {
        this.disposant2valeur3 = disposant2valeur3;
    }

    public Integer getDisposant1valeur4() {
        return disposant1valeur4;
    }

    public void setDisposant1valeur4(Integer disposant1valeur4) {
        this.disposant1valeur4 = disposant1valeur4;
    }

    public Integer getDisposant2valeur4() {
        return disposant2valeur4;
    }

    public void setDisposant2valeur4(Integer disposant2valeur4) {
        this.disposant2valeur4 = disposant2valeur4;
    }

    public Integer getDisposant1valeur5() {
        return disposant1valeur5;
    }

    public void setDisposant1valeur5(Integer disposant1valeur5) {
        this.disposant1valeur5 = disposant1valeur5;
    }

    public Integer getDisposant2valeur5() {
        return disposant2valeur5;
    }

    public void setDisposant2valeur5(Integer disposant2valeur5) {
        this.disposant2valeur5 = disposant2valeur5;
    }

    public Integer getDisposant1valeur6() {
        return disposant1valeur6;
    }

    public void setDisposant1valeur6(Integer disposant1valeur6) {
        this.disposant1valeur6 = disposant1valeur6;
    }

    public Integer getDisposant2valeur6() {
        return disposant2valeur6;
    }

    public void setDisposant2valeur6(Integer disposant2valeur6) {
        this.disposant2valeur6 = disposant2valeur6;
    }

    public Integer getDisposant1valeur7() {
        return disposant1valeur7;
    }

    public void setDisposant1valeur7(Integer disposant1valeur7) {
        this.disposant1valeur7 = disposant1valeur7;
    }

    public Integer getDisposant2valeur7() {
        return disposant2valeur7;
    }

    public void setDisposant2valeur7(Integer disposant2valeur7) {
        this.disposant2valeur7 = disposant2valeur7;
    }

    public Integer getDisposant1valeur8() {
        return disposant1valeur8;
    }

    public void setDisposant1valeur8(Integer disposant1valeur8) {
        this.disposant1valeur8 = disposant1valeur8;
    }

    public Integer getDisposant2valeur8() {
        return disposant2valeur8;
    }

    public void setDisposant2valeur8(Integer disposant2valeur8) {
        this.disposant2valeur8 = disposant2valeur8;
    }

    public Integer getDisposant1valeur9() {
        return disposant1valeur9;
    }

    public void setDisposant1valeur9(Integer disposant1valeur9) {
        this.disposant1valeur9 = disposant1valeur9;
    }

    public Integer getDisposant2valeur9() {
        return disposant2valeur9;
    }

    public void setDisposant2valeur9(Integer disposant2valeur9) {
        this.disposant2valeur9 = disposant2valeur9;
    }

    public Integer getDisposant1valeur10() {
        return disposant1valeur10;
    }

    public void setDisposant1valeur10(Integer disposant1valeur10) {
        this.disposant1valeur10 = disposant1valeur10;
    }

    public Integer getDisposant2valeur10() {
        return disposant2valeur10;
    }

    public void setDisposant2valeur10(Integer disposant2valeur10) {
        this.disposant2valeur10 = disposant2valeur10;
    }

    public Integer getDisposant1valeur11() {
        return disposant1valeur11;
    }

    public void setDisposant1valeur11(Integer disposant1valeur11) {
        this.disposant1valeur11 = disposant1valeur11;
    }

    public Integer getDisposant2valeur11() {
        return disposant2valeur11;
    }

    public void setDisposant2valeur11(Integer disposant2valeur11) {
        this.disposant2valeur11 = disposant2valeur11;
    }

    public Integer getDisposant1valeur12() {
        return disposant1valeur12;
    }

    public void setDisposant1valeur12(Integer disposant1valeur12) {
        this.disposant1valeur12 = disposant1valeur12;
    }

    public Integer getDisposant2valeur12() {
        return disposant2valeur12;
    }

    public void setDisposant2valeur12(Integer disposant2valeur12) {
        this.disposant2valeur12 = disposant2valeur12;
    }

    public String getBeneficiaire1valeur1() {
        return beneficiaire1valeur1;
    }

    public void setBeneficiaire1valeur1(String beneficiaire1valeur1) {
        this.beneficiaire1valeur1 = beneficiaire1valeur1;
    }

    public String getBeneficiaire2valeur1() {
        return beneficiaire2valeur1;
    }

    public void setBeneficiaire2valeur1(String beneficiaire2valeur1) {
        this.beneficiaire2valeur1 = beneficiaire2valeur1;
    }

    public String getBeneficiaire1valeur2() {
        return beneficiaire1valeur2;
    }

    public void setBeneficiaire1valeur2(String beneficiaire1valeur2) {
        this.beneficiaire1valeur2 = beneficiaire1valeur2;
    }

    public Integer getBeneficiaire2valeur2() {
        return beneficiaire2valeur2;
    }

    public void setBeneficiaire2valeur2(Integer beneficiaire2valeur2) {
        this.beneficiaire2valeur2 = beneficiaire2valeur2;
    }

    public String getBeneficiaire1valeur3() {
        return beneficiaire1valeur3;
    }

    public void setBeneficiaire1valeur3(String beneficiaire1valeur3) {
        this.beneficiaire1valeur3 = beneficiaire1valeur3;
    }

    public Integer getBeneficiaire2valeur3() {
        return beneficiaire2valeur3;
    }

    public void setBeneficiaire2valeur3(Integer beneficiaire2valeur3) {
        this.beneficiaire2valeur3 = beneficiaire2valeur3;
    }

    public String getBeneficiaire1valeur4() {
        return beneficiaire1valeur4;
    }

    public void setBeneficiaire1valeur4(String beneficiaire1valeur4) {
        this.beneficiaire1valeur4 = beneficiaire1valeur4;
    }

    public Integer getBeneficiaire2valeur4() {
        return beneficiaire2valeur4;
    }

    public void setBeneficiaire2valeur4(Integer beneficiaire2valeur4) {
        this.beneficiaire2valeur4 = beneficiaire2valeur4;
    }

    public Integer getBeneficiaire1valeur5() {
        return beneficiaire1valeur5;
    }

    public void setBeneficiaire1valeur5(Integer beneficiaire1valeur5) {
        this.beneficiaire1valeur5 = beneficiaire1valeur5;
    }

    public Integer getBeneficiaire2valeur5() {
        return beneficiaire2valeur5;
    }

    public void setBeneficiaire2valeur5(Integer beneficiaire2valeur5) {
        this.beneficiaire2valeur5 = beneficiaire2valeur5;
    }

    public Integer getBeneficiaire1valeur6() {
        return beneficiaire1valeur6;
    }

    public void setBeneficiaire1valeur6(Integer beneficiaire1valeur6) {
        this.beneficiaire1valeur6 = beneficiaire1valeur6;
    }

    public Integer getBeneficiaire2valeur6() {
        return beneficiaire2valeur6;
    }

    public void setBeneficiaire2valeur6(Integer beneficiaire2valeur6) {
        this.beneficiaire2valeur6 = beneficiaire2valeur6;
    }

    public Integer getBeneficiaire1valeur7() {
        return beneficiaire1valeur7;
    }

    public void setBeneficiaire1valeur7(Integer beneficiaire1valeur7) {
        this.beneficiaire1valeur7 = beneficiaire1valeur7;
    }

    public Integer getBeneficiaire2valeur7() {
        return beneficiaire2valeur7;
    }

    public void setBeneficiaire2valeur7(Integer beneficiaire2valeur7) {
        this.beneficiaire2valeur7 = beneficiaire2valeur7;
    }

    public Integer getBeneficiaire1valeur8() {
        return beneficiaire1valeur8;
    }

    public void setBeneficiaire1valeur8(Integer beneficiaire1valeur8) {
        this.beneficiaire1valeur8 = beneficiaire1valeur8;
    }

    public Integer getBeneficiaire2valeur8() {
        return beneficiaire2valeur8;
    }

    public void setBeneficiaire2valeur8(Integer beneficiaire2valeur8) {
        this.beneficiaire2valeur8 = beneficiaire2valeur8;
    }

    public Integer getBeneficiaire1valeur9() {
        return beneficiaire1valeur9;
    }

    public void setBeneficiaire1valeur9(Integer beneficiaire1valeur9) {
        this.beneficiaire1valeur9 = beneficiaire1valeur9;
    }

    public Integer getBeneficiaire2valeur9() {
        return beneficiaire2valeur9;
    }

    public void setBeneficiaire2valeur9(Integer beneficiaire2valeur9) {
        this.beneficiaire2valeur9 = beneficiaire2valeur9;
    }

    public String getLieunonidentifie() {
        return lieunonidentifie;
    }

    public void setLieunonidentifie(String lieunonidentifie) {
        this.lieunonidentifie = lieunonidentifie;
    }

    public String getLieuidentifie() {
        return lieuidentifie;
    }

    public void setLieuidentifie(String lieuidentifie) {
        this.lieuidentifie = lieuidentifie;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getEditionsaw() {
        return editionsaw;
    }

    public void setEditionsaw(String editionsaw) {
        this.editionsaw = editionsaw;
    }

    public String getEditionsnw1valeur1() {
        return editionsnw1valeur1;
    }

    public void setEditionsnw1valeur1(String editionsnw1valeur1) {
        this.editionsnw1valeur1 = editionsnw1valeur1;
    }

    public String getEditionsnw2valeur1() {
        return editionsnw2valeur1;
    }

    public void setEditionsnw2valeur1(String editionsnw2valeur1) {
        this.editionsnw2valeur1 = editionsnw2valeur1;
    }

    public Integer getEditionsnw3valeur1() {
        return editionsnw3valeur1;
    }

    public void setEditionsnw3valeur1(Integer editionsnw3valeur1) {
        this.editionsnw3valeur1 = editionsnw3valeur1;
    }

    public String getEditionsnw4valeur1() {
        return editionsnw4valeur1;
    }

    public void setEditionsnw4valeur1(String editionsnw4valeur1) {
        this.editionsnw4valeur1 = editionsnw4valeur1;
    }

    public String getEditionsnw5valeur1() {
        return editionsnw5valeur1;
    }

    public void setEditionsnw5valeur1(String editionsnw5valeur1) {
        this.editionsnw5valeur1 = editionsnw5valeur1;
    }

    public String getEditionsnwlinkvaleur1() {
        return editionsnwlinkvaleur1;
    }

    public void setEditionsnwlinkvaleur1(String editionsnwlinkvaleur1) {
        this.editionsnwlinkvaleur1 = editionsnwlinkvaleur1;
    }

    public String getEditionsnw1valeur2() {
        return editionsnw1valeur2;
    }

    public void setEditionsnw1valeur2(String editionsnw1valeur2) {
        this.editionsnw1valeur2 = editionsnw1valeur2;
    }

    public String getEditionsnw2valeur2() {
        return editionsnw2valeur2;
    }

    public void setEditionsnw2valeur2(String editionsnw2valeur2) {
        this.editionsnw2valeur2 = editionsnw2valeur2;
    }

    public Integer getEditionsnw3valeur2() {
        return editionsnw3valeur2;
    }

    public void setEditionsnw3valeur2(Integer editionsnw3valeur2) {
        this.editionsnw3valeur2 = editionsnw3valeur2;
    }

    public String getEditionsnw4valeur2() {
        return editionsnw4valeur2;
    }

    public void setEditionsnw4valeur2(String editionsnw4valeur2) {
        this.editionsnw4valeur2 = editionsnw4valeur2;
    }

    public String getEditionsnw5valeur2() {
        return editionsnw5valeur2;
    }

    public void setEditionsnw5valeur2(String editionsnw5valeur2) {
        this.editionsnw5valeur2 = editionsnw5valeur2;
    }

    public Integer getEditionsnwlinkvaleur2() {
        return editionsnwlinkvaleur2;
    }

    public void setEditionsnwlinkvaleur2(Integer editionsnwlinkvaleur2) {
        this.editionsnwlinkvaleur2 = editionsnwlinkvaleur2;
    }

    public String getEditionsnw1valeur3() {
        return editionsnw1valeur3;
    }

    public void setEditionsnw1valeur3(String editionsnw1valeur3) {
        this.editionsnw1valeur3 = editionsnw1valeur3;
    }

    public String getEditionsnw2valeur3() {
        return editionsnw2valeur3;
    }

    public void setEditionsnw2valeur3(String editionsnw2valeur3) {
        this.editionsnw2valeur3 = editionsnw2valeur3;
    }

    public Integer getEditionsnw3valeur3() {
        return editionsnw3valeur3;
    }

    public void setEditionsnw3valeur3(Integer editionsnw3valeur3) {
        this.editionsnw3valeur3 = editionsnw3valeur3;
    }

    public String getEditionsnw4valeur3() {
        return editionsnw4valeur3;
    }

    public void setEditionsnw4valeur3(String editionsnw4valeur3) {
        this.editionsnw4valeur3 = editionsnw4valeur3;
    }

    public String getEditionsnw5valeur3() {
        return editionsnw5valeur3;
    }

    public void setEditionsnw5valeur3(String editionsnw5valeur3) {
        this.editionsnw5valeur3 = editionsnw5valeur3;
    }

    public Integer getEditionsnwlinkvaleur3() {
        return editionsnwlinkvaleur3;
    }

    public void setEditionsnwlinkvaleur3(Integer editionsnwlinkvaleur3) {
        this.editionsnwlinkvaleur3 = editionsnwlinkvaleur3;
    }

    public String getEditionsnw1valeur4() {
        return editionsnw1valeur4;
    }

    public void setEditionsnw1valeur4(String editionsnw1valeur4) {
        this.editionsnw1valeur4 = editionsnw1valeur4;
    }

    public String getEditionsnw2valeur4() {
        return editionsnw2valeur4;
    }

    public void setEditionsnw2valeur4(String editionsnw2valeur4) {
        this.editionsnw2valeur4 = editionsnw2valeur4;
    }

    public Integer getEditionsnw3valeur4() {
        return editionsnw3valeur4;
    }

    public void setEditionsnw3valeur4(Integer editionsnw3valeur4) {
        this.editionsnw3valeur4 = editionsnw3valeur4;
    }

    public String getEditionsnw4valeur4() {
        return editionsnw4valeur4;
    }

    public void setEditionsnw4valeur4(String editionsnw4valeur4) {
        this.editionsnw4valeur4 = editionsnw4valeur4;
    }

    public Integer getEditionsnw5valeur4() {
        return editionsnw5valeur4;
    }

    public void setEditionsnw5valeur4(Integer editionsnw5valeur4) {
        this.editionsnw5valeur4 = editionsnw5valeur4;
    }

    public Integer getEditionsnwlinkvaleur4() {
        return editionsnwlinkvaleur4;
    }

    public void setEditionsnwlinkvaleur4(Integer editionsnwlinkvaleur4) {
        this.editionsnwlinkvaleur4 = editionsnwlinkvaleur4;
    }

    public String getEditionsnw1valeur5() {
        return editionsnw1valeur5;
    }

    public void setEditionsnw1valeur5(String editionsnw1valeur5) {
        this.editionsnw1valeur5 = editionsnw1valeur5;
    }

    public String getEditionsnw2valeur5() {
        return editionsnw2valeur5;
    }

    public void setEditionsnw2valeur5(String editionsnw2valeur5) {
        this.editionsnw2valeur5 = editionsnw2valeur5;
    }

    public Integer getEditionsnw3valeur5() {
        return editionsnw3valeur5;
    }

    public void setEditionsnw3valeur5(Integer editionsnw3valeur5) {
        this.editionsnw3valeur5 = editionsnw3valeur5;
    }

    public String getEditionsnw4valeur5() {
        return editionsnw4valeur5;
    }

    public void setEditionsnw4valeur5(String editionsnw4valeur5) {
        this.editionsnw4valeur5 = editionsnw4valeur5;
    }

    public Integer getEditionsnw5valeur5() {
        return editionsnw5valeur5;
    }

    public void setEditionsnw5valeur5(Integer editionsnw5valeur5) {
        this.editionsnw5valeur5 = editionsnw5valeur5;
    }

    public Integer getEditionsnwlinkvaleur5() {
        return editionsnwlinkvaleur5;
    }

    public void setEditionsnwlinkvaleur5(Integer editionsnwlinkvaleur5) {
        this.editionsnwlinkvaleur5 = editionsnwlinkvaleur5;
    }

    public String getEditionsnw1valeur6() {
        return editionsnw1valeur6;
    }

    public void setEditionsnw1valeur6(String editionsnw1valeur6) {
        this.editionsnw1valeur6 = editionsnw1valeur6;
    }

    public String getEditionsnw2valeur6() {
        return editionsnw2valeur6;
    }

    public void setEditionsnw2valeur6(String editionsnw2valeur6) {
        this.editionsnw2valeur6 = editionsnw2valeur6;
    }

    public Integer getEditionsnw3valeur6() {
        return editionsnw3valeur6;
    }

    public void setEditionsnw3valeur6(Integer editionsnw3valeur6) {
        this.editionsnw3valeur6 = editionsnw3valeur6;
    }

    public String getEditionsnw4valeur6() {
        return editionsnw4valeur6;
    }

    public void setEditionsnw4valeur6(String editionsnw4valeur6) {
        this.editionsnw4valeur6 = editionsnw4valeur6;
    }

    public Integer getEditionsnw5valeur6() {
        return editionsnw5valeur6;
    }

    public void setEditionsnw5valeur6(Integer editionsnw5valeur6) {
        this.editionsnw5valeur6 = editionsnw5valeur6;
    }

    public Integer getEditionsnwlinkvaleur6() {
        return editionsnwlinkvaleur6;
    }

    public void setEditionsnwlinkvaleur6(Integer editionsnwlinkvaleur6) {
        this.editionsnwlinkvaleur6 = editionsnwlinkvaleur6;
    }

    public String getEditionsnw1valeur7() {
        return editionsnw1valeur7;
    }

    public void setEditionsnw1valeur7(String editionsnw1valeur7) {
        this.editionsnw1valeur7 = editionsnw1valeur7;
    }

    public String getEditionsnw2valeur7() {
        return editionsnw2valeur7;
    }

    public void setEditionsnw2valeur7(String editionsnw2valeur7) {
        this.editionsnw2valeur7 = editionsnw2valeur7;
    }

    public Integer getEditionsnw3valeur7() {
        return editionsnw3valeur7;
    }

    public void setEditionsnw3valeur7(Integer editionsnw3valeur7) {
        this.editionsnw3valeur7 = editionsnw3valeur7;
    }

    public String getEditionsnw4valeur7() {
        return editionsnw4valeur7;
    }

    public void setEditionsnw4valeur7(String editionsnw4valeur7) {
        this.editionsnw4valeur7 = editionsnw4valeur7;
    }

    public Integer getEditionsnw5valeur7() {
        return editionsnw5valeur7;
    }

    public void setEditionsnw5valeur7(Integer editionsnw5valeur7) {
        this.editionsnw5valeur7 = editionsnw5valeur7;
    }

    public Integer getEditionsnwlinkvaleur7() {
        return editionsnwlinkvaleur7;
    }

    public void setEditionsnwlinkvaleur7(Integer editionsnwlinkvaleur7) {
        this.editionsnwlinkvaleur7 = editionsnwlinkvaleur7;
    }

    public String getEditionsnw1valeur8() {
        return editionsnw1valeur8;
    }

    public void setEditionsnw1valeur8(String editionsnw1valeur8) {
        this.editionsnw1valeur8 = editionsnw1valeur8;
    }

    public String getEditionsnw2valeur8() {
        return editionsnw2valeur8;
    }

    public void setEditionsnw2valeur8(String editionsnw2valeur8) {
        this.editionsnw2valeur8 = editionsnw2valeur8;
    }

    public Integer getEditionsnw3valeur8() {
        return editionsnw3valeur8;
    }

    public void setEditionsnw3valeur8(Integer editionsnw3valeur8) {
        this.editionsnw3valeur8 = editionsnw3valeur8;
    }

    public String getEditionsnw4valeur8() {
        return editionsnw4valeur8;
    }

    public void setEditionsnw4valeur8(String editionsnw4valeur8) {
        this.editionsnw4valeur8 = editionsnw4valeur8;
    }

    public String getEditionsnw5valeur8() {
        return editionsnw5valeur8;
    }

    public void setEditionsnw5valeur8(String editionsnw5valeur8) {
        this.editionsnw5valeur8 = editionsnw5valeur8;
    }

    public Integer getEditionsnwlinkvaleur8() {
        return editionsnwlinkvaleur8;
    }

    public void setEditionsnwlinkvaleur8(Integer editionsnwlinkvaleur8) {
        this.editionsnwlinkvaleur8 = editionsnwlinkvaleur8;
    }

    public Integer getEditionsnw1valeur9() {
        return editionsnw1valeur9;
    }

    public void setEditionsnw1valeur9(Integer editionsnw1valeur9) {
        this.editionsnw1valeur9 = editionsnw1valeur9;
    }

    public Integer getEditionsnw2valeur9() {
        return editionsnw2valeur9;
    }

    public void setEditionsnw2valeur9(Integer editionsnw2valeur9) {
        this.editionsnw2valeur9 = editionsnw2valeur9;
    }

    public Integer getEditionsnw3valeur9() {
        return editionsnw3valeur9;
    }

    public void setEditionsnw3valeur9(Integer editionsnw3valeur9) {
        this.editionsnw3valeur9 = editionsnw3valeur9;
    }

    public Integer getEditionsnw4valeur9() {
        return editionsnw4valeur9;
    }

    public void setEditionsnw4valeur9(Integer editionsnw4valeur9) {
        this.editionsnw4valeur9 = editionsnw4valeur9;
    }

    public Integer getEditionsnw5valeur9() {
        return editionsnw5valeur9;
    }

    public void setEditionsnw5valeur9(Integer editionsnw5valeur9) {
        this.editionsnw5valeur9 = editionsnw5valeur9;
    }

    public Integer getEditionsnwlinkvaleur9() {
        return editionsnwlinkvaleur9;
    }

    public void setEditionsnwlinkvaleur9(Integer editionsnwlinkvaleur9) {
        this.editionsnwlinkvaleur9 = editionsnwlinkvaleur9;
    }

    public Integer getEditionsnw1valeur10() {
        return editionsnw1valeur10;
    }

    public void setEditionsnw1valeur10(Integer editionsnw1valeur10) {
        this.editionsnw1valeur10 = editionsnw1valeur10;
    }

    public Integer getEditionsnw2valeur10() {
        return editionsnw2valeur10;
    }

    public void setEditionsnw2valeur10(Integer editionsnw2valeur10) {
        this.editionsnw2valeur10 = editionsnw2valeur10;
    }

    public Integer getEditionsnw3valeur10() {
        return editionsnw3valeur10;
    }

    public void setEditionsnw3valeur10(Integer editionsnw3valeur10) {
        this.editionsnw3valeur10 = editionsnw3valeur10;
    }

    public Integer getEditionsnw4valeur10() {
        return editionsnw4valeur10;
    }

    public void setEditionsnw4valeur10(Integer editionsnw4valeur10) {
        this.editionsnw4valeur10 = editionsnw4valeur10;
    }

    public Integer getEditionsnw5valeur10() {
        return editionsnw5valeur10;
    }

    public void setEditionsnw5valeur10(Integer editionsnw5valeur10) {
        this.editionsnw5valeur10 = editionsnw5valeur10;
    }

    public Integer getEditionsnwlinkvaleur10() {
        return editionsnwlinkvaleur10;
    }

    public void setEditionsnwlinkvaleur10(Integer editionsnwlinkvaleur10) {
        this.editionsnwlinkvaleur10 = editionsnwlinkvaleur10;
    }

    public Integer getEditionsnw1valeur11() {
        return editionsnw1valeur11;
    }

    public void setEditionsnw1valeur11(Integer editionsnw1valeur11) {
        this.editionsnw1valeur11 = editionsnw1valeur11;
    }

    public Integer getEditionsnw2valeur11() {
        return editionsnw2valeur11;
    }

    public void setEditionsnw2valeur11(Integer editionsnw2valeur11) {
        this.editionsnw2valeur11 = editionsnw2valeur11;
    }

    public Integer getEditionsnw3valeur11() {
        return editionsnw3valeur11;
    }

    public void setEditionsnw3valeur11(Integer editionsnw3valeur11) {
        this.editionsnw3valeur11 = editionsnw3valeur11;
    }

    public Integer getEditionsnw4valeur11() {
        return editionsnw4valeur11;
    }

    public void setEditionsnw4valeur11(Integer editionsnw4valeur11) {
        this.editionsnw4valeur11 = editionsnw4valeur11;
    }

    public Integer getEditionsnw5valeur11() {
        return editionsnw5valeur11;
    }

    public void setEditionsnw5valeur11(Integer editionsnw5valeur11) {
        this.editionsnw5valeur11 = editionsnw5valeur11;
    }

    public Integer getEditionsnwlinkvaleur11() {
        return editionsnwlinkvaleur11;
    }

    public void setEditionsnwlinkvaleur11(Integer editionsnwlinkvaleur11) {
        this.editionsnwlinkvaleur11 = editionsnwlinkvaleur11;
    }

    public Integer getEditionsnw1valeur12() {
        return editionsnw1valeur12;
    }

    public void setEditionsnw1valeur12(Integer editionsnw1valeur12) {
        this.editionsnw1valeur12 = editionsnw1valeur12;
    }

    public Integer getEditionsnw2valeur12() {
        return editionsnw2valeur12;
    }

    public void setEditionsnw2valeur12(Integer editionsnw2valeur12) {
        this.editionsnw2valeur12 = editionsnw2valeur12;
    }

    public Integer getEditionsnw3valeur12() {
        return editionsnw3valeur12;
    }

    public void setEditionsnw3valeur12(Integer editionsnw3valeur12) {
        this.editionsnw3valeur12 = editionsnw3valeur12;
    }

    public Integer getEditionsnw4valeur12() {
        return editionsnw4valeur12;
    }

    public void setEditionsnw4valeur12(Integer editionsnw4valeur12) {
        this.editionsnw4valeur12 = editionsnw4valeur12;
    }

    public Integer getEditionsnw5valeur12() {
        return editionsnw5valeur12;
    }

    public void setEditionsnw5valeur12(Integer editionsnw5valeur12) {
        this.editionsnw5valeur12 = editionsnw5valeur12;
    }

    public Integer getEditionsnwlinkvaleur12() {
        return editionsnwlinkvaleur12;
    }

    public void setEditionsnwlinkvaleur12(Integer editionsnwlinkvaleur12) {
        this.editionsnwlinkvaleur12 = editionsnwlinkvaleur12;
    }

    public Integer getEditionsnw1valeur13() {
        return editionsnw1valeur13;
    }

    public void setEditionsnw1valeur13(Integer editionsnw1valeur13) {
        this.editionsnw1valeur13 = editionsnw1valeur13;
    }

    public Integer getEditionsnw2valeur13() {
        return editionsnw2valeur13;
    }

    public void setEditionsnw2valeur13(Integer editionsnw2valeur13) {
        this.editionsnw2valeur13 = editionsnw2valeur13;
    }

    public Integer getEditionsnw3valeur13() {
        return editionsnw3valeur13;
    }

    public void setEditionsnw3valeur13(Integer editionsnw3valeur13) {
        this.editionsnw3valeur13 = editionsnw3valeur13;
    }

    public Integer getEditionsnw4valeur13() {
        return editionsnw4valeur13;
    }

    public void setEditionsnw4valeur13(Integer editionsnw4valeur13) {
        this.editionsnw4valeur13 = editionsnw4valeur13;
    }

    public Integer getEditionsnw5valeur13() {
        return editionsnw5valeur13;
    }

    public void setEditionsnw5valeur13(Integer editionsnw5valeur13) {
        this.editionsnw5valeur13 = editionsnw5valeur13;
    }

    public Integer getEditionsnwlinkvaleur13() {
        return editionsnwlinkvaleur13;
    }

    public void setEditionsnwlinkvaleur13(Integer editionsnwlinkvaleur13) {
        this.editionsnwlinkvaleur13 = editionsnwlinkvaleur13;
    }

    public Integer getEditionsnw1valeur14() {
        return editionsnw1valeur14;
    }

    public void setEditionsnw1valeur14(Integer editionsnw1valeur14) {
        this.editionsnw1valeur14 = editionsnw1valeur14;
    }

    public Integer getEditionsnw2valeur14() {
        return editionsnw2valeur14;
    }

    public void setEditionsnw2valeur14(Integer editionsnw2valeur14) {
        this.editionsnw2valeur14 = editionsnw2valeur14;
    }

    public Integer getEditionsnw3valeur14() {
        return editionsnw3valeur14;
    }

    public void setEditionsnw3valeur14(Integer editionsnw3valeur14) {
        this.editionsnw3valeur14 = editionsnw3valeur14;
    }

    public Integer getEditionsnw4valeur14() {
        return editionsnw4valeur14;
    }

    public void setEditionsnw4valeur14(Integer editionsnw4valeur14) {
        this.editionsnw4valeur14 = editionsnw4valeur14;
    }

    public Integer getEditionsnw5valeur14() {
        return editionsnw5valeur14;
    }

    public void setEditionsnw5valeur14(Integer editionsnw5valeur14) {
        this.editionsnw5valeur14 = editionsnw5valeur14;
    }

    public Integer getEditionsnwlinkvaleur14() {
        return editionsnwlinkvaleur14;
    }

    public void setEditionsnwlinkvaleur14(Integer editionsnwlinkvaleur14) {
        this.editionsnwlinkvaleur14 = editionsnwlinkvaleur14;
    }

    public Integer getEditionsnw1valeur15() {
        return editionsnw1valeur15;
    }

    public void setEditionsnw1valeur15(Integer editionsnw1valeur15) {
        this.editionsnw1valeur15 = editionsnw1valeur15;
    }

    public Integer getEditionsnw2valeur15() {
        return editionsnw2valeur15;
    }

    public void setEditionsnw2valeur15(Integer editionsnw2valeur15) {
        this.editionsnw2valeur15 = editionsnw2valeur15;
    }

    public Integer getEditionsnw3valeur15() {
        return editionsnw3valeur15;
    }

    public void setEditionsnw3valeur15(Integer editionsnw3valeur15) {
        this.editionsnw3valeur15 = editionsnw3valeur15;
    }

    public Integer getEditionsnw4valeur15() {
        return editionsnw4valeur15;
    }

    public void setEditionsnw4valeur15(Integer editionsnw4valeur15) {
        this.editionsnw4valeur15 = editionsnw4valeur15;
    }

    public Integer getEditionsnw5valeur15() {
        return editionsnw5valeur15;
    }

    public void setEditionsnw5valeur15(Integer editionsnw5valeur15) {
        this.editionsnw5valeur15 = editionsnw5valeur15;
    }

    public Integer getEditionsnwlinkvaleur15() {
        return editionsnwlinkvaleur15;
    }

    public void setEditionsnwlinkvaleur15(Integer editionsnwlinkvaleur15) {
        this.editionsnwlinkvaleur15 = editionsnwlinkvaleur15;
    }

    public Integer getEditionsnw1valeur16() {
        return editionsnw1valeur16;
    }

    public void setEditionsnw1valeur16(Integer editionsnw1valeur16) {
        this.editionsnw1valeur16 = editionsnw1valeur16;
    }

    public Integer getEditionsnw2valeur16() {
        return editionsnw2valeur16;
    }

    public void setEditionsnw2valeur16(Integer editionsnw2valeur16) {
        this.editionsnw2valeur16 = editionsnw2valeur16;
    }

    public Integer getEditionsnw3valeur16() {
        return editionsnw3valeur16;
    }

    public void setEditionsnw3valeur16(Integer editionsnw3valeur16) {
        this.editionsnw3valeur16 = editionsnw3valeur16;
    }

    public Integer getEditionsnw4valeur16() {
        return editionsnw4valeur16;
    }

    public void setEditionsnw4valeur16(Integer editionsnw4valeur16) {
        this.editionsnw4valeur16 = editionsnw4valeur16;
    }

    public Integer getEditionsnw5valeur16() {
        return editionsnw5valeur16;
    }

    public void setEditionsnw5valeur16(Integer editionsnw5valeur16) {
        this.editionsnw5valeur16 = editionsnw5valeur16;
    }

    public Integer getEditionsnwlinkvaleur16() {
        return editionsnwlinkvaleur16;
    }

    public void setEditionsnwlinkvaleur16(Integer editionsnwlinkvaleur16) {
        this.editionsnwlinkvaleur16 = editionsnwlinkvaleur16;
    }

    public Integer getEditionsnw1valeur17() {
        return editionsnw1valeur17;
    }

    public void setEditionsnw1valeur17(Integer editionsnw1valeur17) {
        this.editionsnw1valeur17 = editionsnw1valeur17;
    }

    public Integer getEditionsnw2valeur17() {
        return editionsnw2valeur17;
    }

    public void setEditionsnw2valeur17(Integer editionsnw2valeur17) {
        this.editionsnw2valeur17 = editionsnw2valeur17;
    }

    public Integer getEditionsnw3valeur17() {
        return editionsnw3valeur17;
    }

    public void setEditionsnw3valeur17(Integer editionsnw3valeur17) {
        this.editionsnw3valeur17 = editionsnw3valeur17;
    }

    public Integer getEditionsnw4valeur17() {
        return editionsnw4valeur17;
    }

    public void setEditionsnw4valeur17(Integer editionsnw4valeur17) {
        this.editionsnw4valeur17 = editionsnw4valeur17;
    }

    public Integer getEditionsnw5valeur17() {
        return editionsnw5valeur17;
    }

    public void setEditionsnw5valeur17(Integer editionsnw5valeur17) {
        this.editionsnw5valeur17 = editionsnw5valeur17;
    }

    public Integer getEditionsnwlinkvaleur17() {
        return editionsnwlinkvaleur17;
    }

    public void setEditionsnwlinkvaleur17(Integer editionsnwlinkvaleur17) {
        this.editionsnwlinkvaleur17 = editionsnwlinkvaleur17;
    }

    public Integer getEditionsnw1valeur18() {
        return editionsnw1valeur18;
    }

    public void setEditionsnw1valeur18(Integer editionsnw1valeur18) {
        this.editionsnw1valeur18 = editionsnw1valeur18;
    }

    public Integer getEditionsnw2valeur18() {
        return editionsnw2valeur18;
    }

    public void setEditionsnw2valeur18(Integer editionsnw2valeur18) {
        this.editionsnw2valeur18 = editionsnw2valeur18;
    }

    public Integer getEditionsnw3valeur18() {
        return editionsnw3valeur18;
    }

    public void setEditionsnw3valeur18(Integer editionsnw3valeur18) {
        this.editionsnw3valeur18 = editionsnw3valeur18;
    }

    public Integer getEditionsnw4valeur18() {
        return editionsnw4valeur18;
    }

    public void setEditionsnw4valeur18(Integer editionsnw4valeur18) {
        this.editionsnw4valeur18 = editionsnw4valeur18;
    }

    public Integer getEditionsnw5valeur18() {
        return editionsnw5valeur18;
    }

    public void setEditionsnw5valeur18(Integer editionsnw5valeur18) {
        this.editionsnw5valeur18 = editionsnw5valeur18;
    }

    public Integer getEditionsnwlinkvaleur18() {
        return editionsnwlinkvaleur18;
    }

    public void setEditionsnwlinkvaleur18(Integer editionsnwlinkvaleur18) {
        this.editionsnwlinkvaleur18 = editionsnwlinkvaleur18;
    }

    public Integer getEditionsnw1valeur19() {
        return editionsnw1valeur19;
    }

    public void setEditionsnw1valeur19(Integer editionsnw1valeur19) {
        this.editionsnw1valeur19 = editionsnw1valeur19;
    }

    public Integer getEditionsnw2valeur19() {
        return editionsnw2valeur19;
    }

    public void setEditionsnw2valeur19(Integer editionsnw2valeur19) {
        this.editionsnw2valeur19 = editionsnw2valeur19;
    }

    public Integer getEditionsnw3valeur19() {
        return editionsnw3valeur19;
    }

    public void setEditionsnw3valeur19(Integer editionsnw3valeur19) {
        this.editionsnw3valeur19 = editionsnw3valeur19;
    }

    public Integer getEditionsnw4valeur19() {
        return editionsnw4valeur19;
    }

    public void setEditionsnw4valeur19(Integer editionsnw4valeur19) {
        this.editionsnw4valeur19 = editionsnw4valeur19;
    }

    public Integer getEditionsnw5valeur19() {
        return editionsnw5valeur19;
    }

    public void setEditionsnw5valeur19(Integer editionsnw5valeur19) {
        this.editionsnw5valeur19 = editionsnw5valeur19;
    }

    public Integer getEditionsnwlinkvaleur19() {
        return editionsnwlinkvaleur19;
    }

    public void setEditionsnwlinkvaleur19(Integer editionsnwlinkvaleur19) {
        this.editionsnwlinkvaleur19 = editionsnwlinkvaleur19;
    }

    public Integer getEditionsnw1valeur20() {
        return editionsnw1valeur20;
    }

    public void setEditionsnw1valeur20(Integer editionsnw1valeur20) {
        this.editionsnw1valeur20 = editionsnw1valeur20;
    }

    public Integer getEditionsnw2valeur20() {
        return editionsnw2valeur20;
    }

    public void setEditionsnw2valeur20(Integer editionsnw2valeur20) {
        this.editionsnw2valeur20 = editionsnw2valeur20;
    }

    public Integer getEditionsnw3valeur20() {
        return editionsnw3valeur20;
    }

    public void setEditionsnw3valeur20(Integer editionsnw3valeur20) {
        this.editionsnw3valeur20 = editionsnw3valeur20;
    }

    public Integer getEditionsnw4valeur20() {
        return editionsnw4valeur20;
    }

    public void setEditionsnw4valeur20(Integer editionsnw4valeur20) {
        this.editionsnw4valeur20 = editionsnw4valeur20;
    }

    public Integer getEditionsnw5valeur20() {
        return editionsnw5valeur20;
    }

    public void setEditionsnw5valeur20(Integer editionsnw5valeur20) {
        this.editionsnw5valeur20 = editionsnw5valeur20;
    }

    public Integer getEditionsnwlinkvaleur20() {
        return editionsnwlinkvaleur20;
    }

    public void setEditionsnwlinkvaleur20(Integer editionsnwlinkvaleur20) {
        this.editionsnwlinkvaleur20 = editionsnwlinkvaleur20;
    }

    public String getEtudesnw1valeur1() {
        return etudesnw1valeur1;
    }

    public void setEtudesnw1valeur1(String etudesnw1valeur1) {
        this.etudesnw1valeur1 = etudesnw1valeur1;
    }

    public String getEtudesnw2valeur1() {
        return etudesnw2valeur1;
    }

    public void setEtudesnw2valeur1(String etudesnw2valeur1) {
        this.etudesnw2valeur1 = etudesnw2valeur1;
    }

    public Integer getEtudesnw3valeur1() {
        return etudesnw3valeur1;
    }

    public void setEtudesnw3valeur1(Integer etudesnw3valeur1) {
        this.etudesnw3valeur1 = etudesnw3valeur1;
    }

    public String getEtudesnw4valeur1() {
        return etudesnw4valeur1;
    }

    public void setEtudesnw4valeur1(String etudesnw4valeur1) {
        this.etudesnw4valeur1 = etudesnw4valeur1;
    }

    public String getEtudesnw5valeur1() {
        return etudesnw5valeur1;
    }

    public void setEtudesnw5valeur1(String etudesnw5valeur1) {
        this.etudesnw5valeur1 = etudesnw5valeur1;
    }

    public String getEtudesnwlinkvaleur1() {
        return etudesnwlinkvaleur1;
    }

    public void setEtudesnwlinkvaleur1(String etudesnwlinkvaleur1) {
        this.etudesnwlinkvaleur1 = etudesnwlinkvaleur1;
    }

    public String getEtudesnw1valeur2() {
        return etudesnw1valeur2;
    }

    public void setEtudesnw1valeur2(String etudesnw1valeur2) {
        this.etudesnw1valeur2 = etudesnw1valeur2;
    }

    public String getEtudesnw2valeur2() {
        return etudesnw2valeur2;
    }

    public void setEtudesnw2valeur2(String etudesnw2valeur2) {
        this.etudesnw2valeur2 = etudesnw2valeur2;
    }

    public Integer getEtudesnw3valeur2() {
        return etudesnw3valeur2;
    }

    public void setEtudesnw3valeur2(Integer etudesnw3valeur2) {
        this.etudesnw3valeur2 = etudesnw3valeur2;
    }

    public String getEtudesnw4valeur2() {
        return etudesnw4valeur2;
    }

    public void setEtudesnw4valeur2(String etudesnw4valeur2) {
        this.etudesnw4valeur2 = etudesnw4valeur2;
    }

    public String getEtudesnw5valeur2() {
        return etudesnw5valeur2;
    }

    public void setEtudesnw5valeur2(String etudesnw5valeur2) {
        this.etudesnw5valeur2 = etudesnw5valeur2;
    }

    public Integer getEtudesnwlinkvaleur2() {
        return etudesnwlinkvaleur2;
    }

    public void setEtudesnwlinkvaleur2(Integer etudesnwlinkvaleur2) {
        this.etudesnwlinkvaleur2 = etudesnwlinkvaleur2;
    }

    public String getEtudesnw1valeur3() {
        return etudesnw1valeur3;
    }

    public void setEtudesnw1valeur3(String etudesnw1valeur3) {
        this.etudesnw1valeur3 = etudesnw1valeur3;
    }

    public String getEtudesnw2valeur3() {
        return etudesnw2valeur3;
    }

    public void setEtudesnw2valeur3(String etudesnw2valeur3) {
        this.etudesnw2valeur3 = etudesnw2valeur3;
    }

    public Integer getEtudesnw3valeur3() {
        return etudesnw3valeur3;
    }

    public void setEtudesnw3valeur3(Integer etudesnw3valeur3) {
        this.etudesnw3valeur3 = etudesnw3valeur3;
    }

    public String getEtudesnw4valeur3() {
        return etudesnw4valeur3;
    }

    public void setEtudesnw4valeur3(String etudesnw4valeur3) {
        this.etudesnw4valeur3 = etudesnw4valeur3;
    }

    public Integer getEtudesnw5valeur3() {
        return etudesnw5valeur3;
    }

    public void setEtudesnw5valeur3(Integer etudesnw5valeur3) {
        this.etudesnw5valeur3 = etudesnw5valeur3;
    }

    public Integer getEtudesnwlinkvaleur3() {
        return etudesnwlinkvaleur3;
    }

    public void setEtudesnwlinkvaleur3(Integer etudesnwlinkvaleur3) {
        this.etudesnwlinkvaleur3 = etudesnwlinkvaleur3;
    }

    public String getEtudesnw1valeur4() {
        return etudesnw1valeur4;
    }

    public void setEtudesnw1valeur4(String etudesnw1valeur4) {
        this.etudesnw1valeur4 = etudesnw1valeur4;
    }

    public String getEtudesnw2valeur4() {
        return etudesnw2valeur4;
    }

    public void setEtudesnw2valeur4(String etudesnw2valeur4) {
        this.etudesnw2valeur4 = etudesnw2valeur4;
    }

    public Integer getEtudesnw3valeur4() {
        return etudesnw3valeur4;
    }

    public void setEtudesnw3valeur4(Integer etudesnw3valeur4) {
        this.etudesnw3valeur4 = etudesnw3valeur4;
    }

    public String getEtudesnw4valeur4() {
        return etudesnw4valeur4;
    }

    public void setEtudesnw4valeur4(String etudesnw4valeur4) {
        this.etudesnw4valeur4 = etudesnw4valeur4;
    }

    public String getEtudesnw5valeur4() {
        return etudesnw5valeur4;
    }

    public void setEtudesnw5valeur4(String etudesnw5valeur4) {
        this.etudesnw5valeur4 = etudesnw5valeur4;
    }

    public Integer getEtudesnwlinkvaleur4() {
        return etudesnwlinkvaleur4;
    }

    public void setEtudesnwlinkvaleur4(Integer etudesnwlinkvaleur4) {
        this.etudesnwlinkvaleur4 = etudesnwlinkvaleur4;
    }

    public String getEtudesnw1valeur5() {
        return etudesnw1valeur5;
    }

    public void setEtudesnw1valeur5(String etudesnw1valeur5) {
        this.etudesnw1valeur5 = etudesnw1valeur5;
    }

    public String getEtudesnw2valeur5() {
        return etudesnw2valeur5;
    }

    public void setEtudesnw2valeur5(String etudesnw2valeur5) {
        this.etudesnw2valeur5 = etudesnw2valeur5;
    }

    public Integer getEtudesnw3valeur5() {
        return etudesnw3valeur5;
    }

    public void setEtudesnw3valeur5(Integer etudesnw3valeur5) {
        this.etudesnw3valeur5 = etudesnw3valeur5;
    }

    public String getEtudesnw4valeur5() {
        return etudesnw4valeur5;
    }

    public void setEtudesnw4valeur5(String etudesnw4valeur5) {
        this.etudesnw4valeur5 = etudesnw4valeur5;
    }

    public Integer getEtudesnw5valeur5() {
        return etudesnw5valeur5;
    }

    public void setEtudesnw5valeur5(Integer etudesnw5valeur5) {
        this.etudesnw5valeur5 = etudesnw5valeur5;
    }

    public Integer getEtudesnwlinkvaleur5() {
        return etudesnwlinkvaleur5;
    }

    public void setEtudesnwlinkvaleur5(Integer etudesnwlinkvaleur5) {
        this.etudesnwlinkvaleur5 = etudesnwlinkvaleur5;
    }

    public String getEtudesnw1valeur6() {
        return etudesnw1valeur6;
    }

    public void setEtudesnw1valeur6(String etudesnw1valeur6) {
        this.etudesnw1valeur6 = etudesnw1valeur6;
    }

    public String getEtudesnw2valeur6() {
        return etudesnw2valeur6;
    }

    public void setEtudesnw2valeur6(String etudesnw2valeur6) {
        this.etudesnw2valeur6 = etudesnw2valeur6;
    }

    public Integer getEtudesnw3valeur6() {
        return etudesnw3valeur6;
    }

    public void setEtudesnw3valeur6(Integer etudesnw3valeur6) {
        this.etudesnw3valeur6 = etudesnw3valeur6;
    }

    public String getEtudesnw4valeur6() {
        return etudesnw4valeur6;
    }

    public void setEtudesnw4valeur6(String etudesnw4valeur6) {
        this.etudesnw4valeur6 = etudesnw4valeur6;
    }

    public Integer getEtudesnw5valeur6() {
        return etudesnw5valeur6;
    }

    public void setEtudesnw5valeur6(Integer etudesnw5valeur6) {
        this.etudesnw5valeur6 = etudesnw5valeur6;
    }

    public Integer getEtudesnwlinkvaleur6() {
        return etudesnwlinkvaleur6;
    }

    public void setEtudesnwlinkvaleur6(Integer etudesnwlinkvaleur6) {
        this.etudesnwlinkvaleur6 = etudesnwlinkvaleur6;
    }

    public String getEtudesnw1valeur7() {
        return etudesnw1valeur7;
    }

    public void setEtudesnw1valeur7(String etudesnw1valeur7) {
        this.etudesnw1valeur7 = etudesnw1valeur7;
    }

    public String getEtudesnw2valeur7() {
        return etudesnw2valeur7;
    }

    public void setEtudesnw2valeur7(String etudesnw2valeur7) {
        this.etudesnw2valeur7 = etudesnw2valeur7;
    }

    public Integer getEtudesnw3valeur7() {
        return etudesnw3valeur7;
    }

    public void setEtudesnw3valeur7(Integer etudesnw3valeur7) {
        this.etudesnw3valeur7 = etudesnw3valeur7;
    }

    public String getEtudesnw4valeur7() {
        return etudesnw4valeur7;
    }

    public void setEtudesnw4valeur7(String etudesnw4valeur7) {
        this.etudesnw4valeur7 = etudesnw4valeur7;
    }

    public Integer getEtudesnw5valeur7() {
        return etudesnw5valeur7;
    }

    public void setEtudesnw5valeur7(Integer etudesnw5valeur7) {
        this.etudesnw5valeur7 = etudesnw5valeur7;
    }

    public Integer getEtudesnwlinkvaleur7() {
        return etudesnwlinkvaleur7;
    }

    public void setEtudesnwlinkvaleur7(Integer etudesnwlinkvaleur7) {
        this.etudesnwlinkvaleur7 = etudesnwlinkvaleur7;
    }

    public String getEtudesnw1valeur8() {
        return etudesnw1valeur8;
    }

    public void setEtudesnw1valeur8(String etudesnw1valeur8) {
        this.etudesnw1valeur8 = etudesnw1valeur8;
    }

    public String getEtudesnw2valeur8() {
        return etudesnw2valeur8;
    }

    public void setEtudesnw2valeur8(String etudesnw2valeur8) {
        this.etudesnw2valeur8 = etudesnw2valeur8;
    }

    public Integer getEtudesnw3valeur8() {
        return etudesnw3valeur8;
    }

    public void setEtudesnw3valeur8(Integer etudesnw3valeur8) {
        this.etudesnw3valeur8 = etudesnw3valeur8;
    }

    public String getEtudesnw4valeur8() {
        return etudesnw4valeur8;
    }

    public void setEtudesnw4valeur8(String etudesnw4valeur8) {
        this.etudesnw4valeur8 = etudesnw4valeur8;
    }

    public Integer getEtudesnw5valeur8() {
        return etudesnw5valeur8;
    }

    public void setEtudesnw5valeur8(Integer etudesnw5valeur8) {
        this.etudesnw5valeur8 = etudesnw5valeur8;
    }

    public Integer getEtudesnwlinkvaleur8() {
        return etudesnwlinkvaleur8;
    }

    public void setEtudesnwlinkvaleur8(Integer etudesnwlinkvaleur8) {
        this.etudesnwlinkvaleur8 = etudesnwlinkvaleur8;
    }

    public String getEtudesnw1valeur9() {
        return etudesnw1valeur9;
    }

    public void setEtudesnw1valeur9(String etudesnw1valeur9) {
        this.etudesnw1valeur9 = etudesnw1valeur9;
    }

    public String getEtudesnw2valeur9() {
        return etudesnw2valeur9;
    }

    public void setEtudesnw2valeur9(String etudesnw2valeur9) {
        this.etudesnw2valeur9 = etudesnw2valeur9;
    }

    public Integer getEtudesnw3valeur9() {
        return etudesnw3valeur9;
    }

    public void setEtudesnw3valeur9(Integer etudesnw3valeur9) {
        this.etudesnw3valeur9 = etudesnw3valeur9;
    }

    public String getEtudesnw4valeur9() {
        return etudesnw4valeur9;
    }

    public void setEtudesnw4valeur9(String etudesnw4valeur9) {
        this.etudesnw4valeur9 = etudesnw4valeur9;
    }

    public Integer getEtudesnw5valeur9() {
        return etudesnw5valeur9;
    }

    public void setEtudesnw5valeur9(Integer etudesnw5valeur9) {
        this.etudesnw5valeur9 = etudesnw5valeur9;
    }

    public Integer getEtudesnwlinkvaleur9() {
        return etudesnwlinkvaleur9;
    }

    public void setEtudesnwlinkvaleur9(Integer etudesnwlinkvaleur9) {
        this.etudesnwlinkvaleur9 = etudesnwlinkvaleur9;
    }

    public Integer getEtudesnw1valeur10() {
        return etudesnw1valeur10;
    }

    public void setEtudesnw1valeur10(Integer etudesnw1valeur10) {
        this.etudesnw1valeur10 = etudesnw1valeur10;
    }

    public Integer getEtudesnw2valeur10() {
        return etudesnw2valeur10;
    }

    public void setEtudesnw2valeur10(Integer etudesnw2valeur10) {
        this.etudesnw2valeur10 = etudesnw2valeur10;
    }

    public Integer getEtudesnw3valeur10() {
        return etudesnw3valeur10;
    }

    public void setEtudesnw3valeur10(Integer etudesnw3valeur10) {
        this.etudesnw3valeur10 = etudesnw3valeur10;
    }

    public Integer getEtudesnw4valeur10() {
        return etudesnw4valeur10;
    }

    public void setEtudesnw4valeur10(Integer etudesnw4valeur10) {
        this.etudesnw4valeur10 = etudesnw4valeur10;
    }

    public Integer getEtudesnw5valeur10() {
        return etudesnw5valeur10;
    }

    public void setEtudesnw5valeur10(Integer etudesnw5valeur10) {
        this.etudesnw5valeur10 = etudesnw5valeur10;
    }

    public Integer getEtudesnwlinkvaleur10() {
        return etudesnwlinkvaleur10;
    }

    public void setEtudesnwlinkvaleur10(Integer etudesnwlinkvaleur10) {
        this.etudesnwlinkvaleur10 = etudesnwlinkvaleur10;
    }

    public Integer getEtudesnw1valeur11() {
        return etudesnw1valeur11;
    }

    public void setEtudesnw1valeur11(Integer etudesnw1valeur11) {
        this.etudesnw1valeur11 = etudesnw1valeur11;
    }

    public Integer getEtudesnw2valeur11() {
        return etudesnw2valeur11;
    }

    public void setEtudesnw2valeur11(Integer etudesnw2valeur11) {
        this.etudesnw2valeur11 = etudesnw2valeur11;
    }

    public Integer getEtudesnw3valeur11() {
        return etudesnw3valeur11;
    }

    public void setEtudesnw3valeur11(Integer etudesnw3valeur11) {
        this.etudesnw3valeur11 = etudesnw3valeur11;
    }

    public Integer getEtudesnw4valeur11() {
        return etudesnw4valeur11;
    }

    public void setEtudesnw4valeur11(Integer etudesnw4valeur11) {
        this.etudesnw4valeur11 = etudesnw4valeur11;
    }

    public Integer getEtudesnw5valeur11() {
        return etudesnw5valeur11;
    }

    public void setEtudesnw5valeur11(Integer etudesnw5valeur11) {
        this.etudesnw5valeur11 = etudesnw5valeur11;
    }

    public Integer getEtudesnwlinkvaleur11() {
        return etudesnwlinkvaleur11;
    }

    public void setEtudesnwlinkvaleur11(Integer etudesnwlinkvaleur11) {
        this.etudesnwlinkvaleur11 = etudesnwlinkvaleur11;
    }

    public Integer getEtudesnw1valeur12() {
        return etudesnw1valeur12;
    }

    public void setEtudesnw1valeur12(Integer etudesnw1valeur12) {
        this.etudesnw1valeur12 = etudesnw1valeur12;
    }

    public Integer getEtudesnw2valeur12() {
        return etudesnw2valeur12;
    }

    public void setEtudesnw2valeur12(Integer etudesnw2valeur12) {
        this.etudesnw2valeur12 = etudesnw2valeur12;
    }

    public Integer getEtudesnw3valeur12() {
        return etudesnw3valeur12;
    }

    public void setEtudesnw3valeur12(Integer etudesnw3valeur12) {
        this.etudesnw3valeur12 = etudesnw3valeur12;
    }

    public Integer getEtudesnw4valeur12() {
        return etudesnw4valeur12;
    }

    public void setEtudesnw4valeur12(Integer etudesnw4valeur12) {
        this.etudesnw4valeur12 = etudesnw4valeur12;
    }

    public Integer getEtudesnw5valeur12() {
        return etudesnw5valeur12;
    }

    public void setEtudesnw5valeur12(Integer etudesnw5valeur12) {
        this.etudesnw5valeur12 = etudesnw5valeur12;
    }

    public Integer getEtudesnwlinkvaleur12() {
        return etudesnwlinkvaleur12;
    }

    public void setEtudesnwlinkvaleur12(Integer etudesnwlinkvaleur12) {
        this.etudesnwlinkvaleur12 = etudesnwlinkvaleur12;
    }

    public Integer getEtudesnw1valeur13() {
        return etudesnw1valeur13;
    }

    public void setEtudesnw1valeur13(Integer etudesnw1valeur13) {
        this.etudesnw1valeur13 = etudesnw1valeur13;
    }

    public Integer getEtudesnw2valeur13() {
        return etudesnw2valeur13;
    }

    public void setEtudesnw2valeur13(Integer etudesnw2valeur13) {
        this.etudesnw2valeur13 = etudesnw2valeur13;
    }

    public Integer getEtudesnw3valeur13() {
        return etudesnw3valeur13;
    }

    public void setEtudesnw3valeur13(Integer etudesnw3valeur13) {
        this.etudesnw3valeur13 = etudesnw3valeur13;
    }

    public Integer getEtudesnw4valeur13() {
        return etudesnw4valeur13;
    }

    public void setEtudesnw4valeur13(Integer etudesnw4valeur13) {
        this.etudesnw4valeur13 = etudesnw4valeur13;
    }

    public Integer getEtudesnw5valeur13() {
        return etudesnw5valeur13;
    }

    public void setEtudesnw5valeur13(Integer etudesnw5valeur13) {
        this.etudesnw5valeur13 = etudesnw5valeur13;
    }

    public Integer getEtudesnwlinkvaleur13() {
        return etudesnwlinkvaleur13;
    }

    public void setEtudesnwlinkvaleur13(Integer etudesnwlinkvaleur13) {
        this.etudesnwlinkvaleur13 = etudesnwlinkvaleur13;
    }

    public Integer getEtudesnw1valeur14() {
        return etudesnw1valeur14;
    }

    public void setEtudesnw1valeur14(Integer etudesnw1valeur14) {
        this.etudesnw1valeur14 = etudesnw1valeur14;
    }

    public Integer getEtudesnw2valeur14() {
        return etudesnw2valeur14;
    }

    public void setEtudesnw2valeur14(Integer etudesnw2valeur14) {
        this.etudesnw2valeur14 = etudesnw2valeur14;
    }

    public Integer getEtudesnw3valeur14() {
        return etudesnw3valeur14;
    }

    public void setEtudesnw3valeur14(Integer etudesnw3valeur14) {
        this.etudesnw3valeur14 = etudesnw3valeur14;
    }

    public Integer getEtudesnw4valeur14() {
        return etudesnw4valeur14;
    }

    public void setEtudesnw4valeur14(Integer etudesnw4valeur14) {
        this.etudesnw4valeur14 = etudesnw4valeur14;
    }

    public Integer getEtudesnw5valeur14() {
        return etudesnw5valeur14;
    }

    public void setEtudesnw5valeur14(Integer etudesnw5valeur14) {
        this.etudesnw5valeur14 = etudesnw5valeur14;
    }

    public Integer getEtudesnwlinkvaleur14() {
        return etudesnwlinkvaleur14;
    }

    public void setEtudesnwlinkvaleur14(Integer etudesnwlinkvaleur14) {
        this.etudesnwlinkvaleur14 = etudesnwlinkvaleur14;
    }

    public Integer getEtudesnw1valeur15() {
        return etudesnw1valeur15;
    }

    public void setEtudesnw1valeur15(Integer etudesnw1valeur15) {
        this.etudesnw1valeur15 = etudesnw1valeur15;
    }

    public Integer getEtudesnw2valeur15() {
        return etudesnw2valeur15;
    }

    public void setEtudesnw2valeur15(Integer etudesnw2valeur15) {
        this.etudesnw2valeur15 = etudesnw2valeur15;
    }

    public Integer getEtudesnw3valeur15() {
        return etudesnw3valeur15;
    }

    public void setEtudesnw3valeur15(Integer etudesnw3valeur15) {
        this.etudesnw3valeur15 = etudesnw3valeur15;
    }

    public Integer getEtudesnw4valeur15() {
        return etudesnw4valeur15;
    }

    public void setEtudesnw4valeur15(Integer etudesnw4valeur15) {
        this.etudesnw4valeur15 = etudesnw4valeur15;
    }

    public Integer getEtudesnw5valeur15() {
        return etudesnw5valeur15;
    }

    public void setEtudesnw5valeur15(Integer etudesnw5valeur15) {
        this.etudesnw5valeur15 = etudesnw5valeur15;
    }

    public Integer getEtudesnwlinkvaleur15() {
        return etudesnwlinkvaleur15;
    }

    public void setEtudesnwlinkvaleur15(Integer etudesnwlinkvaleur15) {
        this.etudesnwlinkvaleur15 = etudesnwlinkvaleur15;
    }

    public Integer getEtudesnw1valeur16() {
        return etudesnw1valeur16;
    }

    public void setEtudesnw1valeur16(Integer etudesnw1valeur16) {
        this.etudesnw1valeur16 = etudesnw1valeur16;
    }

    public Integer getEtudesnw2valeur16() {
        return etudesnw2valeur16;
    }

    public void setEtudesnw2valeur16(Integer etudesnw2valeur16) {
        this.etudesnw2valeur16 = etudesnw2valeur16;
    }

    public Integer getEtudesnw3valeur16() {
        return etudesnw3valeur16;
    }

    public void setEtudesnw3valeur16(Integer etudesnw3valeur16) {
        this.etudesnw3valeur16 = etudesnw3valeur16;
    }

    public Integer getEtudesnw4valeur16() {
        return etudesnw4valeur16;
    }

    public void setEtudesnw4valeur16(Integer etudesnw4valeur16) {
        this.etudesnw4valeur16 = etudesnw4valeur16;
    }

    public Integer getEtudesnw5valeur16() {
        return etudesnw5valeur16;
    }

    public void setEtudesnw5valeur16(Integer etudesnw5valeur16) {
        this.etudesnw5valeur16 = etudesnw5valeur16;
    }

    public Integer getEtudesnwlinkvaleur16() {
        return etudesnwlinkvaleur16;
    }

    public void setEtudesnwlinkvaleur16(Integer etudesnwlinkvaleur16) {
        this.etudesnwlinkvaleur16 = etudesnwlinkvaleur16;
    }

    public Integer getEtudesnw1valeur17() {
        return etudesnw1valeur17;
    }

    public void setEtudesnw1valeur17(Integer etudesnw1valeur17) {
        this.etudesnw1valeur17 = etudesnw1valeur17;
    }

    public Integer getEtudesnw2valeur17() {
        return etudesnw2valeur17;
    }

    public void setEtudesnw2valeur17(Integer etudesnw2valeur17) {
        this.etudesnw2valeur17 = etudesnw2valeur17;
    }

    public Integer getEtudesnw3valeur17() {
        return etudesnw3valeur17;
    }

    public void setEtudesnw3valeur17(Integer etudesnw3valeur17) {
        this.etudesnw3valeur17 = etudesnw3valeur17;
    }

    public Integer getEtudesnw4valeur17() {
        return etudesnw4valeur17;
    }

    public void setEtudesnw4valeur17(Integer etudesnw4valeur17) {
        this.etudesnw4valeur17 = etudesnw4valeur17;
    }

    public Integer getEtudesnw5valeur17() {
        return etudesnw5valeur17;
    }

    public void setEtudesnw5valeur17(Integer etudesnw5valeur17) {
        this.etudesnw5valeur17 = etudesnw5valeur17;
    }

    public Integer getEtudesnwlinkvaleur17() {
        return etudesnwlinkvaleur17;
    }

    public void setEtudesnwlinkvaleur17(Integer etudesnwlinkvaleur17) {
        this.etudesnwlinkvaleur17 = etudesnwlinkvaleur17;
    }

    public Integer getEtudesnw1valeur18() {
        return etudesnw1valeur18;
    }

    public void setEtudesnw1valeur18(Integer etudesnw1valeur18) {
        this.etudesnw1valeur18 = etudesnw1valeur18;
    }

    public Integer getEtudesnw2valeur18() {
        return etudesnw2valeur18;
    }

    public void setEtudesnw2valeur18(Integer etudesnw2valeur18) {
        this.etudesnw2valeur18 = etudesnw2valeur18;
    }

    public Integer getEtudesnw3valeur18() {
        return etudesnw3valeur18;
    }

    public void setEtudesnw3valeur18(Integer etudesnw3valeur18) {
        this.etudesnw3valeur18 = etudesnw3valeur18;
    }

    public Integer getEtudesnw4valeur18() {
        return etudesnw4valeur18;
    }

    public void setEtudesnw4valeur18(Integer etudesnw4valeur18) {
        this.etudesnw4valeur18 = etudesnw4valeur18;
    }

    public Integer getEtudesnw5valeur18() {
        return etudesnw5valeur18;
    }

    public void setEtudesnw5valeur18(Integer etudesnw5valeur18) {
        this.etudesnw5valeur18 = etudesnw5valeur18;
    }

    public Integer getEtudesnwlinkvaleur18() {
        return etudesnwlinkvaleur18;
    }

    public void setEtudesnwlinkvaleur18(Integer etudesnwlinkvaleur18) {
        this.etudesnwlinkvaleur18 = etudesnwlinkvaleur18;
    }

    public Integer getEtudesnw1valeur19() {
        return etudesnw1valeur19;
    }

    public void setEtudesnw1valeur19(Integer etudesnw1valeur19) {
        this.etudesnw1valeur19 = etudesnw1valeur19;
    }

    public Integer getEtudesnw2valeur19() {
        return etudesnw2valeur19;
    }

    public void setEtudesnw2valeur19(Integer etudesnw2valeur19) {
        this.etudesnw2valeur19 = etudesnw2valeur19;
    }

    public Integer getEtudesnw3valeur19() {
        return etudesnw3valeur19;
    }

    public void setEtudesnw3valeur19(Integer etudesnw3valeur19) {
        this.etudesnw3valeur19 = etudesnw3valeur19;
    }

    public Integer getEtudesnw4valeur19() {
        return etudesnw4valeur19;
    }

    public void setEtudesnw4valeur19(Integer etudesnw4valeur19) {
        this.etudesnw4valeur19 = etudesnw4valeur19;
    }

    public Integer getEtudesnw5valeur19() {
        return etudesnw5valeur19;
    }

    public void setEtudesnw5valeur19(Integer etudesnw5valeur19) {
        this.etudesnw5valeur19 = etudesnw5valeur19;
    }

    public Integer getEtudesnwlinkvaleur19() {
        return etudesnwlinkvaleur19;
    }

    public void setEtudesnwlinkvaleur19(Integer etudesnwlinkvaleur19) {
        this.etudesnwlinkvaleur19 = etudesnwlinkvaleur19;
    }

    public Integer getEtudesnw1valeur20() {
        return etudesnw1valeur20;
    }

    public void setEtudesnw1valeur20(Integer etudesnw1valeur20) {
        this.etudesnw1valeur20 = etudesnw1valeur20;
    }

    public Integer getEtudesnw2valeur20() {
        return etudesnw2valeur20;
    }

    public void setEtudesnw2valeur20(Integer etudesnw2valeur20) {
        this.etudesnw2valeur20 = etudesnw2valeur20;
    }

    public Integer getEtudesnw3valeur20() {
        return etudesnw3valeur20;
    }

    public void setEtudesnw3valeur20(Integer etudesnw3valeur20) {
        this.etudesnw3valeur20 = etudesnw3valeur20;
    }

    public Integer getEtudesnw4valeur20() {
        return etudesnw4valeur20;
    }

    public void setEtudesnw4valeur20(Integer etudesnw4valeur20) {
        this.etudesnw4valeur20 = etudesnw4valeur20;
    }

    public Integer getEtudesnw5valeur20() {
        return etudesnw5valeur20;
    }

    public void setEtudesnw5valeur20(Integer etudesnw5valeur20) {
        this.etudesnw5valeur20 = etudesnw5valeur20;
    }

    public Integer getEtudesnwlinkvaleur20() {
        return etudesnwlinkvaleur20;
    }

    public void setEtudesnwlinkvaleur20(Integer etudesnwlinkvaleur20) {
        this.etudesnwlinkvaleur20 = etudesnwlinkvaleur20;
    }

    public String getEditiondlmd1valeur1() {
        return editiondlmd1valeur1;
    }

    public void setEditiondlmd1valeur1(String editiondlmd1valeur1) {
        this.editiondlmd1valeur1 = editiondlmd1valeur1;
    }

    public String getEditiondlmd2valeur1() {
        return editiondlmd2valeur1;
    }

    public void setEditiondlmd2valeur1(String editiondlmd2valeur1) {
        this.editiondlmd2valeur1 = editiondlmd2valeur1;
    }

    public String getEditiondlmd3valeur1() {
        return editiondlmd3valeur1;
    }

    public void setEditiondlmd3valeur1(String editiondlmd3valeur1) {
        this.editiondlmd3valeur1 = editiondlmd3valeur1;
    }

    public String getEditiondlmd4valeur1() {
        return editiondlmd4valeur1;
    }

    public void setEditiondlmd4valeur1(String editiondlmd4valeur1) {
        this.editiondlmd4valeur1 = editiondlmd4valeur1;
    }

    public Integer getEditiondlmd5valeur1() {
        return editiondlmd5valeur1;
    }

    public void setEditiondlmd5valeur1(Integer editiondlmd5valeur1) {
        this.editiondlmd5valeur1 = editiondlmd5valeur1;
    }

    public Integer getEditiondlmdlinkvaleur1() {
        return editiondlmdlinkvaleur1;
    }

    public void setEditiondlmdlinkvaleur1(Integer editiondlmdlinkvaleur1) {
        this.editiondlmdlinkvaleur1 = editiondlmdlinkvaleur1;
    }

    public String getOriginal1valeur1() {
        return original1valeur1;
    }

    public void setOriginal1valeur1(String original1valeur1) {
        this.original1valeur1 = original1valeur1;
    }

    public String getOriginal2valeur1() {
        return original2valeur1;
    }

    public void setOriginal2valeur1(String original2valeur1) {
        this.original2valeur1 = original2valeur1;
    }

    public String getOriginal3valeur1() {
        return original3valeur1;
    }

    public void setOriginal3valeur1(String original3valeur1) {
        this.original3valeur1 = original3valeur1;
    }

    public Integer getOriginal1valeur2() {
        return original1valeur2;
    }

    public void setOriginal1valeur2(Integer original1valeur2) {
        this.original1valeur2 = original1valeur2;
    }

    public Integer getOriginal2valeur2() {
        return original2valeur2;
    }

    public void setOriginal2valeur2(Integer original2valeur2) {
        this.original2valeur2 = original2valeur2;
    }

    public Integer getOriginal3valeur2() {
        return original3valeur2;
    }

    public void setOriginal3valeur2(Integer original3valeur2) {
        this.original3valeur2 = original3valeur2;
    }

    public Integer getOriginal1valeur3() {
        return original1valeur3;
    }

    public void setOriginal1valeur3(Integer original1valeur3) {
        this.original1valeur3 = original1valeur3;
    }

    public Integer getOriginal2valeur3() {
        return original2valeur3;
    }

    public void setOriginal2valeur3(Integer original2valeur3) {
        this.original2valeur3 = original2valeur3;
    }

    public Integer getOriginal3valeur3() {
        return original3valeur3;
    }

    public void setOriginal3valeur3(Integer original3valeur3) {
        this.original3valeur3 = original3valeur3;
    }

    public String getCopies1valeur1() {
        return copies1valeur1;
    }

    public void setCopies1valeur1(String copies1valeur1) {
        this.copies1valeur1 = copies1valeur1;
    }

    public String getCopies2valeur1() {
        return copies2valeur1;
    }

    public void setCopies2valeur1(String copies2valeur1) {
        this.copies2valeur1 = copies2valeur1;
    }

    public String getCopies3valeur1() {
        return copies3valeur1;
    }

    public void setCopies3valeur1(String copies3valeur1) {
        this.copies3valeur1 = copies3valeur1;
    }

    public String getCopies4valeur1() {
        return copies4valeur1;
    }

    public void setCopies4valeur1(String copies4valeur1) {
        this.copies4valeur1 = copies4valeur1;
    }

    public Integer getCopies5valeur1() {
        return copies5valeur1;
    }

    public void setCopies5valeur1(Integer copies5valeur1) {
        this.copies5valeur1 = copies5valeur1;
    }

    public String getCopies1valeur2() {
        return copies1valeur2;
    }

    public void setCopies1valeur2(String copies1valeur2) {
        this.copies1valeur2 = copies1valeur2;
    }

    public String getCopies2valeur2() {
        return copies2valeur2;
    }

    public void setCopies2valeur2(String copies2valeur2) {
        this.copies2valeur2 = copies2valeur2;
    }

    public String getCopies3valeur2() {
        return copies3valeur2;
    }

    public void setCopies3valeur2(String copies3valeur2) {
        this.copies3valeur2 = copies3valeur2;
    }

    public String getCopies4valeur2() {
        return copies4valeur2;
    }

    public void setCopies4valeur2(String copies4valeur2) {
        this.copies4valeur2 = copies4valeur2;
    }

    public Integer getCopies5valeur2() {
        return copies5valeur2;
    }

    public void setCopies5valeur2(Integer copies5valeur2) {
        this.copies5valeur2 = copies5valeur2;
    }

    public String getCopies1valeur3() {
        return copies1valeur3;
    }

    public void setCopies1valeur3(String copies1valeur3) {
        this.copies1valeur3 = copies1valeur3;
    }

    public String getCopies2valeur3() {
        return copies2valeur3;
    }

    public void setCopies2valeur3(String copies2valeur3) {
        this.copies2valeur3 = copies2valeur3;
    }

    public String getCopies3valeur3() {
        return copies3valeur3;
    }

    public void setCopies3valeur3(String copies3valeur3) {
        this.copies3valeur3 = copies3valeur3;
    }

    public String getCopies4valeur3() {
        return copies4valeur3;
    }

    public void setCopies4valeur3(String copies4valeur3) {
        this.copies4valeur3 = copies4valeur3;
    }

    public Integer getCopies5valeur3() {
        return copies5valeur3;
    }

    public void setCopies5valeur3(Integer copies5valeur3) {
        this.copies5valeur3 = copies5valeur3;
    }

    public String getCopies1valeur4() {
        return copies1valeur4;
    }

    public void setCopies1valeur4(String copies1valeur4) {
        this.copies1valeur4 = copies1valeur4;
    }

    public String getCopies2valeur4() {
        return copies2valeur4;
    }

    public void setCopies2valeur4(String copies2valeur4) {
        this.copies2valeur4 = copies2valeur4;
    }

    public String getCopies3valeur4() {
        return copies3valeur4;
    }

    public void setCopies3valeur4(String copies3valeur4) {
        this.copies3valeur4 = copies3valeur4;
    }

    public String getCopies4valeur4() {
        return copies4valeur4;
    }

    public void setCopies4valeur4(String copies4valeur4) {
        this.copies4valeur4 = copies4valeur4;
    }

    public Integer getCopies5valeur4() {
        return copies5valeur4;
    }

    public void setCopies5valeur4(Integer copies5valeur4) {
        this.copies5valeur4 = copies5valeur4;
    }

    public String getCopies1valeur5() {
        return copies1valeur5;
    }

    public void setCopies1valeur5(String copies1valeur5) {
        this.copies1valeur5 = copies1valeur5;
    }

    public String getCopies2valeur5() {
        return copies2valeur5;
    }

    public void setCopies2valeur5(String copies2valeur5) {
        this.copies2valeur5 = copies2valeur5;
    }

    public String getCopies3valeur5() {
        return copies3valeur5;
    }

    public void setCopies3valeur5(String copies3valeur5) {
        this.copies3valeur5 = copies3valeur5;
    }

    public String getCopies4valeur5() {
        return copies4valeur5;
    }

    public void setCopies4valeur5(String copies4valeur5) {
        this.copies4valeur5 = copies4valeur5;
    }

    public Integer getCopies5valeur5() {
        return copies5valeur5;
    }

    public void setCopies5valeur5(Integer copies5valeur5) {
        this.copies5valeur5 = copies5valeur5;
    }

    public String getCopies1valeur6() {
        return copies1valeur6;
    }

    public void setCopies1valeur6(String copies1valeur6) {
        this.copies1valeur6 = copies1valeur6;
    }

    public String getCopies2valeur6() {
        return copies2valeur6;
    }

    public void setCopies2valeur6(String copies2valeur6) {
        this.copies2valeur6 = copies2valeur6;
    }

    public String getCopies3valeur6() {
        return copies3valeur6;
    }

    public void setCopies3valeur6(String copies3valeur6) {
        this.copies3valeur6 = copies3valeur6;
    }

    public String getCopies4valeur6() {
        return copies4valeur6;
    }

    public void setCopies4valeur6(String copies4valeur6) {
        this.copies4valeur6 = copies4valeur6;
    }

    public Integer getCopies5valeur6() {
        return copies5valeur6;
    }

    public void setCopies5valeur6(Integer copies5valeur6) {
        this.copies5valeur6 = copies5valeur6;
    }

    public Integer getCopies1valeur7() {
        return copies1valeur7;
    }

    public void setCopies1valeur7(Integer copies1valeur7) {
        this.copies1valeur7 = copies1valeur7;
    }

    public Integer getCopies2valeur7() {
        return copies2valeur7;
    }

    public void setCopies2valeur7(Integer copies2valeur7) {
        this.copies2valeur7 = copies2valeur7;
    }

    public Integer getCopies3valeur7() {
        return copies3valeur7;
    }

    public void setCopies3valeur7(Integer copies3valeur7) {
        this.copies3valeur7 = copies3valeur7;
    }

    public Integer getCopies4valeur7() {
        return copies4valeur7;
    }

    public void setCopies4valeur7(Integer copies4valeur7) {
        this.copies4valeur7 = copies4valeur7;
    }

    public Integer getCopies5valeur7() {
        return copies5valeur7;
    }

    public void setCopies5valeur7(Integer copies5valeur7) {
        this.copies5valeur7 = copies5valeur7;
    }

    public Integer getCopies1valeur8() {
        return copies1valeur8;
    }

    public void setCopies1valeur8(Integer copies1valeur8) {
        this.copies1valeur8 = copies1valeur8;
    }

    public Integer getCopies2valeur8() {
        return copies2valeur8;
    }

    public void setCopies2valeur8(Integer copies2valeur8) {
        this.copies2valeur8 = copies2valeur8;
    }

    public Integer getCopies3valeur8() {
        return copies3valeur8;
    }

    public void setCopies3valeur8(Integer copies3valeur8) {
        this.copies3valeur8 = copies3valeur8;
    }

    public Integer getCopies4valeur8() {
        return copies4valeur8;
    }

    public void setCopies4valeur8(Integer copies4valeur8) {
        this.copies4valeur8 = copies4valeur8;
    }

    public Integer getCopies5valeur8() {
        return copies5valeur8;
    }

    public void setCopies5valeur8(Integer copies5valeur8) {
        this.copies5valeur8 = copies5valeur8;
    }

    public Integer getCopies1valeur9() {
        return copies1valeur9;
    }

    public void setCopies1valeur9(Integer copies1valeur9) {
        this.copies1valeur9 = copies1valeur9;
    }

    public Integer getCopies2valeur9() {
        return copies2valeur9;
    }

    public void setCopies2valeur9(Integer copies2valeur9) {
        this.copies2valeur9 = copies2valeur9;
    }

    public Integer getCopies3valeur9() {
        return copies3valeur9;
    }

    public void setCopies3valeur9(Integer copies3valeur9) {
        this.copies3valeur9 = copies3valeur9;
    }

    public Integer getCopies4valeur9() {
        return copies4valeur9;
    }

    public void setCopies4valeur9(Integer copies4valeur9) {
        this.copies4valeur9 = copies4valeur9;
    }

    public Integer getCopies5valeur9() {
        return copies5valeur9;
    }

    public void setCopies5valeur9(Integer copies5valeur9) {
        this.copies5valeur9 = copies5valeur9;
    }

    public Integer getCopies1valeur10() {
        return copies1valeur10;
    }

    public void setCopies1valeur10(Integer copies1valeur10) {
        this.copies1valeur10 = copies1valeur10;
    }

    public Integer getCopies2valeur10() {
        return copies2valeur10;
    }

    public void setCopies2valeur10(Integer copies2valeur10) {
        this.copies2valeur10 = copies2valeur10;
    }

    public Integer getCopies3valeur10() {
        return copies3valeur10;
    }

    public void setCopies3valeur10(Integer copies3valeur10) {
        this.copies3valeur10 = copies3valeur10;
    }

    public Integer getCopies4valeur10() {
        return copies4valeur10;
    }

    public void setCopies4valeur10(Integer copies4valeur10) {
        this.copies4valeur10 = copies4valeur10;
    }

    public Integer getCopies5valeur10() {
        return copies5valeur10;
    }

    public void setCopies5valeur10(Integer copies5valeur10) {
        this.copies5valeur10 = copies5valeur10;
    }

    public Integer getCopies1valeur11() {
        return copies1valeur11;
    }

    public void setCopies1valeur11(Integer copies1valeur11) {
        this.copies1valeur11 = copies1valeur11;
    }

    public Integer getCopies2valeur11() {
        return copies2valeur11;
    }

    public void setCopies2valeur11(Integer copies2valeur11) {
        this.copies2valeur11 = copies2valeur11;
    }

    public Integer getCopies3valeur11() {
        return copies3valeur11;
    }

    public void setCopies3valeur11(Integer copies3valeur11) {
        this.copies3valeur11 = copies3valeur11;
    }

    public Integer getCopies4valeur11() {
        return copies4valeur11;
    }

    public void setCopies4valeur11(Integer copies4valeur11) {
        this.copies4valeur11 = copies4valeur11;
    }

    public Integer getCopies5valeur11() {
        return copies5valeur11;
    }

    public void setCopies5valeur11(Integer copies5valeur11) {
        this.copies5valeur11 = copies5valeur11;
    }

    public Integer getCopies1valeur12() {
        return copies1valeur12;
    }

    public void setCopies1valeur12(Integer copies1valeur12) {
        this.copies1valeur12 = copies1valeur12;
    }

    public Integer getCopies2valeur12() {
        return copies2valeur12;
    }

    public void setCopies2valeur12(Integer copies2valeur12) {
        this.copies2valeur12 = copies2valeur12;
    }

    public Integer getCopies3valeur12() {
        return copies3valeur12;
    }

    public void setCopies3valeur12(Integer copies3valeur12) {
        this.copies3valeur12 = copies3valeur12;
    }

    public Integer getCopies4valeur12() {
        return copies4valeur12;
    }

    public void setCopies4valeur12(Integer copies4valeur12) {
        this.copies4valeur12 = copies4valeur12;
    }

    public Integer getCopies5valeur12() {
        return copies5valeur12;
    }

    public void setCopies5valeur12(Integer copies5valeur12) {
        this.copies5valeur12 = copies5valeur12;
    }

    public Integer getCopies1valeur13() {
        return copies1valeur13;
    }

    public void setCopies1valeur13(Integer copies1valeur13) {
        this.copies1valeur13 = copies1valeur13;
    }

    public Integer getCopies2valeur13() {
        return copies2valeur13;
    }

    public void setCopies2valeur13(Integer copies2valeur13) {
        this.copies2valeur13 = copies2valeur13;
    }

    public Integer getCopies3valeur13() {
        return copies3valeur13;
    }

    public void setCopies3valeur13(Integer copies3valeur13) {
        this.copies3valeur13 = copies3valeur13;
    }

    public Integer getCopies4valeur13() {
        return copies4valeur13;
    }

    public void setCopies4valeur13(Integer copies4valeur13) {
        this.copies4valeur13 = copies4valeur13;
    }

    public Integer getCopies1valeur14() {
        return copies1valeur14;
    }

    public void setCopies1valeur14(Integer copies1valeur14) {
        this.copies1valeur14 = copies1valeur14;
    }

    public Integer getCopies2valeur14() {
        return copies2valeur14;
    }

    public void setCopies2valeur14(Integer copies2valeur14) {
        this.copies2valeur14 = copies2valeur14;
    }

    public Integer getCopies3valeur14() {
        return copies3valeur14;
    }

    public void setCopies3valeur14(Integer copies3valeur14) {
        this.copies3valeur14 = copies3valeur14;
    }

    public Integer getCopies4valeur14() {
        return copies4valeur14;
    }

    public void setCopies4valeur14(Integer copies4valeur14) {
        this.copies4valeur14 = copies4valeur14;
    }

    public Integer getCopies5valeur14() {
        return copies5valeur14;
    }

    public void setCopies5valeur14(Integer copies5valeur14) {
        this.copies5valeur14 = copies5valeur14;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerowauters != null ? numerowauters.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contents)) {
            return false;
        }
        Contents other = (Contents) object;
        if ((this.numerowauters == null && other.numerowauters != null) || (this.numerowauters != null && !this.numerowauters.equals(other.numerowauters))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.ugr.decsai.historydb.model.Contents[ numerowauters=" + numerowauters + " ]";
    }
    
}
