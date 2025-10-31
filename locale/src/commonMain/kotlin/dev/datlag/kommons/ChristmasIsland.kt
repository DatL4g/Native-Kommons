package dev.datlag.kommons


data object ChristmasIsland : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("CX")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("CXR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(162)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(61)
    override val continent: Continent = Continent.Asia
}