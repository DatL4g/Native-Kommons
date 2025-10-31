package dev.datlag.kommons


data object Thailand : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TH")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("THA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(764)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(66)
    override val continent: Continent = Continent.Asia
}