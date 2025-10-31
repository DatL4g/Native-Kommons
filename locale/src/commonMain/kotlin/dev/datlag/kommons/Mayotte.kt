package dev.datlag.kommons


data object Mayotte : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("YT")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MYT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(175)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(262, 269, 639)
    override val continent: Continent = Continent.Africa
}