package dev.datlag.kommons


data object Niue : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NU")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NIU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(570)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(683)
    override val continent: Continent = Continent.Oceania
}