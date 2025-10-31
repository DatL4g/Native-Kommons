package dev.datlag.kommons


data object HeardIslandAndMcDonaldIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("HM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("HMD")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(334)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(672)
    override val continent: Continent = Continent.Antarctica
}