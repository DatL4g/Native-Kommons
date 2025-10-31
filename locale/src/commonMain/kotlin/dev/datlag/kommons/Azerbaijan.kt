package dev.datlag.kommons


data object Azerbaijan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AZ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("AZE")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(31)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(994)
    override val continent: Continent = Continent.Asia
}