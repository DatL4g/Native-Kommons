package dev.datlag.kommons


data object Anguilla : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AI")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("AIA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(660)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1264)
    override val continent: Continent = Continent.NorthAmerica
}