package dev.datlag.kommons


data object FaroeIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("FO")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("FRO")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(234)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(298)
}