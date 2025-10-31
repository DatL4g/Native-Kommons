package dev.datlag.kommons


data object Cambodia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KH")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KHM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(116)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(855)
    override val continent: Continent = Continent.Asia
}