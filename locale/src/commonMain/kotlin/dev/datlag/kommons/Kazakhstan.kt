package dev.datlag.kommons


data object Kazakhstan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KZ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KAZ")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(398)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(7)
    override val continent: Continent = Continent.Asia
}