package dev.datlag.kommons


data object Mauritania : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MRT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(478)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(222)
    override val continent: Continent = Continent.Africa
}