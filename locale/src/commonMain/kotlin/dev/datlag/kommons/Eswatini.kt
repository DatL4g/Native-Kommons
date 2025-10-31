package dev.datlag.kommons


data object Eswatini : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SZ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SWZ")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(748)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(268)
    override val continent: Continent = Continent.Africa
}