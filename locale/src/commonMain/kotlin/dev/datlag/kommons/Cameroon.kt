package dev.datlag.kommons


data object Cameroon : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("CM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("CMR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(120)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(237)
    override val continent: Continent = Continent.Africa
}