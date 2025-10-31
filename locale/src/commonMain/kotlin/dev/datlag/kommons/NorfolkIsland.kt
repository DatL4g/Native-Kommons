package dev.datlag.kommons


data object NorfolkIsland : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NF")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NFK")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(574)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(672)
    override val continent: Continent = Continent.Oceania
}