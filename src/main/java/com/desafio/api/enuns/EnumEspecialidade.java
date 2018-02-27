/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.enuns;

/**
 *
 * @author deoprog
 */
public enum EnumEspecialidade {
    ANATOMIA_PATOLOGICA("Anatomia Patológica"),
    ANESTESIOLOGIA("Anestesiologia"),
    ANGIOLOGIA_E_CIRURGIA_VASCULAR("Angiologia e Cirurgia Vascular"),
    CARDIOLOGIA("Cardiologia"),
    CARDIOLOGIA_PEDIATRICA("Cardiologia Pediátrica"),
    CIRURGIA_CARDIOTORACICA("Cirurgia Cardiotorácica"),
    CIRURGIA_GERAL("Cirurgia Geral"),
    CIRURGIA_MAXILO_FACIAL("Cirurgia Máxilo-Facial"),
    CIRURGIA_PEDIATRICA("Cirurgia Pediátrica"),
    CIRURGIA_PLASTICA_RECONSTRUTIVA_E_ESTETICA("Cirurgia Plástica Reconstrutiva e Estética"),
    DERMATO_VENEREOLOGIA("Dermato-Venereologia"),
    DOENCAS_INFECCIOSAS("Doenças Infecciosas"),
    ENDOCRINOLOGIA_E_NUTRICAO("Endocrinologia e Nutrição"),
    ESTOMATOLOGIA("Estomatologia"),
    GASTRENTEROLOGIA("Gastrenterologia"),
    GENETICA_MEDICA("Genética Médica"),
    GINECOLOGIA_E_OBSTETRICIA("Ginecologia e Obstetrícia"),
    IMUNOALERGOLOGIA("Imunoalergologia"),
    IMUNO_HEMOTERAPIA("Imuno-hemoterapia"),
    FARMACOLOGIA_CLINICA("Farmacologia Clínica"),
    HEMATOLOGIA_CLINICA("Hematologia Clínica"),
    MEDICINA_DESPORTIVA("Medicina desportiva"),
    MEDICINA_DO_TRABALHO("Medicina do Trabalho"),
    MEDICINA_FISICA_E_DE_REABILITACAO("Medicina Física e de Reabilitação"),
    MEDICINA_GERAL_E_FAMILIAR("Medicina Geral e Familiar"),
    MEDICINA_INTENSIVA("Medicina Intensiva"),
    MEDICINA_INTERNA("Medicina Interna"),
    MEDICINA_LEGAL("Medicina Legal"),
    MEDICINA_NUCLEAR("Medicina Nuclear"),
    MEDICINA_TROPICAL("Medicina Tropical"),
    NEFROLOGIA("Nefrologia"),
    NEUROCIRURGIA("Neurocirurgia"),
    NEUROLOGIA("Neurologia"),
    NEURORRADIOLOGIA("Neurorradiologia"),
    OFTALMOLOGIA("Oftalmologia"),
    ONCOLOGIA_MEDICA("Oncologia Médica"),
    ORTOPEDIA("Ortopedia"),
    OTORRINOLARINGOLOGIA("Otorrinolaringologia"),
    PATOLOGIA_CLINICA("Patologia Clínica"),
    PEDIATRIA("Pediatria"),
    PNEUMOLOGIA("Pneumologia"),
    PSIQUIATRIA("Psiquiatria"),
    PSIQUIATRIA_DA_INFÂNCIA_E_DA_ADOLESCENCIA("Psiquiatria da Infância e da Adolescência"),
    RADIOLOGIA("Radiologia"),
    RADIONCOLOGIA("Radioncologia"),
    REUMATOLOGIA("Reumatologia"),
    SAÚDE_PÚBLICA("Saúde Pública"),
    UROLOGIA("Urologia");
    
    private final String label;

    private EnumEspecialidade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
