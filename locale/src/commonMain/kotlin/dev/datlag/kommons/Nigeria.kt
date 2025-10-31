package dev.datlag.kommons


data object Nigeria : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NGA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(566)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(234)
    override val continent: Continent = Continent.Africa
}