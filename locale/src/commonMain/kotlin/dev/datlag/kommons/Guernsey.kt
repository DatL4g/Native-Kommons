package dev.datlag.kommons


data object Guernsey : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GGY")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(831)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(44)
    override val continent: Continent = Continent.Europe
}