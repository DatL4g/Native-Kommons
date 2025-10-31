package dev.datlag.kommons


data object Algeria : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("DZ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("DZA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(12)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(213)
    override val continent: Continent = Continent.Africa
}