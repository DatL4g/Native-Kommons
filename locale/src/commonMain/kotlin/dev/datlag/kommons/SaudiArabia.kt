package dev.datlag.kommons


data object SaudiArabia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SA")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SAU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(682)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(966)
    override val continent: Continent = Continent.Asia
}