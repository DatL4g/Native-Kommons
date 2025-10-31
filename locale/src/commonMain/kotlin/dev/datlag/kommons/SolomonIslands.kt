package dev.datlag.kommons


data object SolomonIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SB")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SLB")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(90)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(677)
    override val continent: Continent = Continent.Oceania
}