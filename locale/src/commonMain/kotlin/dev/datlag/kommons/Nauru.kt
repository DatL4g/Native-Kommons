package dev.datlag.kommons


data object Nauru : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NRU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(520)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(674)
    override val continent: Continent = Continent.Oceania
}