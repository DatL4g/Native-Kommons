package dev.datlag.kommons


data object Ireland : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("IE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("IRL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(372)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(353)
    override val continent: Continent = Continent.Europe
}