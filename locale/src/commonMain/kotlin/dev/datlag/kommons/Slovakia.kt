package dev.datlag.kommons


data object Slovakia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SK")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SVK")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(703)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(421)
    override val continent: Continent = Continent.Europe
}