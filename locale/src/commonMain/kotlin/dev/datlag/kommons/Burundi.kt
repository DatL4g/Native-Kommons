package dev.datlag.kommons


data object Burundi : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BI")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BDI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(108)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(257)
    override val continent: Continent = Continent.Africa
}