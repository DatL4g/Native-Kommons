package dev.datlag.kommons


data object Micronesia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("FM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("FSM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(583)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(691)
    override val continent: Continent = Continent.Oceania
}