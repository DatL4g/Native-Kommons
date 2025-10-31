package dev.datlag.kommons


data object MarshallIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MH")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MHL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(584)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(692)
    override val continent: Continent = Continent.Oceania
}